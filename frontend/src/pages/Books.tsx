import axios from "axios";
import { useEffect, useState } from "react";
import Modal from "../components/Modal";    
import BookCard from "../components/BookCard";
import BorrowBookModal from "../components/BorrowBookModal";
import CreateBookModal from "../components/CreateBookModal";
import UpdateBookModal, { Author } from "../components/UpdateBookModal";
import SearchBar from "../components/SearchBar";

export interface Book {
  bookId: number,
  coverImageUrl: string,
  title: string,
  publicationYear: number,
  authors: { 
    id:number,
    name: string,
    nationality: string,
    portraitUrl: string
  }[],
  isbn: string,
  status: string,
}

export default function Books() {  

    const [bookList, setBookList] = useState<Book[]>([]);
    const [isShowModalBorrow, setIsShowModalBorrow] = useState(false);
    const [isShowModalCreate, setIsShowModalCreate] = useState(false);
    const [isShowModalUpdate, setIsShowModalUpdate] = useState(false);
    const [currentBookId, setCurrentBookId] = useState<number>();
    const [currentBook, setCurrentBook] = useState<Book>();
    const [searchQuery, setSearchQuery] = useState<string>('');

    const handleGetBooks = async () => {  
        try {
            const res = await axios.get (import.meta.env.VITE_BASE_URL + '/books');
            if (res.status === 200) {
                setBookList(res.data);
                console.log(res.data);
            }
        } catch (error) {
            console.error(error);
        }
    };

    const searchList = bookList.filter((book) => {
        const searchByTitle = book.title.toLowerCase().includes(searchQuery.toLowerCase());
        const searchByAuthor = book.authors[0].name.toLowerCase().includes(searchQuery.toLowerCase());
        return searchByTitle || searchByAuthor;
    });

    const handleOpenModalBorrow = (id:number) => {
        setCurrentBookId(id);
        setIsShowModalBorrow(true);
    };

    const handleCloseModalBorrow = () => {
        setIsShowModalBorrow(false);
    };

    const handleOpenModalCreate = () => {
        setIsShowModalCreate(true);
    };

    const handleCloseModalCreate = () => {
        setIsShowModalCreate(false);
    };

    const handleOpenModalUpdate = (book:any) => {
        setIsShowModalUpdate(true);
        setCurrentBook(book);
    };

    const handleCloseModalUpdate = () => {
        setIsShowModalUpdate(false);
    };

    const handleSubmitBorrow = async ({id,date}:{id:number, date:Date}) => {
        try {
            const res = await axios.post(import.meta.env.VITE_BASE_URL + '/borrowings', {
                bookId: currentBookId,
                borrowerId: id,
                dueDate: date
            });
            if (res) {
                console.log(res.data);
                handleGetBooks();
            }
        } catch (error) {
            console.error(error);
        }
        handleCloseModalBorrow();
    }
    
    const handleSubmitCreate = async ({title, isbn, publicationYear, author,coverImageUrl} : {title: string, isbn: string, publicationYear: string, author: any, coverImageUrl: string}) => {

        try {
            const res = await axios.post (import.meta.env.VITE_BASE_URL + '/books', {
                bookId: 0,
                title: title,
                isbn: isbn,
                publicationYear: parseInt(publicationYear),
                authors: [{
                    id: author[0].authorId,
                    name: author[0].name,
                    nationality: author[0].nationality,
                    portraitUrl: author[0].portraitUrl
                }],
                status: "AVAILABLE",
                coverImageUrl: coverImageUrl
            });

            if (res) {
                console.log(res.data);
                handleGetBooks();
            }
        } catch (error) {
            console.error(error);
        }
        handleCloseModalCreate();
    };

    const handleSubmitUpdate = async ({title, isbn, publicationYear, authors, coverImageUrl} : { title: string, isbn: string, publicationYear: string, authors: Author, coverImageUrl: string}) => {
        try {
            const res = await axios.put (import.meta.env.VITE_BASE_URL + '/books/' + currentBook!.bookId, {
                bookId: currentBook!.bookId,
                title: title,
                isbn: isbn,
                publicationYear: parseInt(publicationYear),
                authors:[
                    {
                        id: authors.authorId,
                        name: authors.name,
                        nationality: authors.nationality,
                        portraitUrl: authors.portraitUrl
                    }
                ],
                status: currentBook!.status,
                coverImage: coverImageUrl
            })
            if (res) {
                console.log(res.data);
                handleGetBooks();
            }
        } catch (error) {
            console.error(error);
        }
        handleCloseModalUpdate();
    };

    const handleDelete = async (id: number) => {
        try {
            const res = await axios.delete(import.meta.env.VITE_BASE_URL + '/books/' + id);
            if (res) {
                console.log(res.data);
                handleGetBooks();
            }
        } catch (error) {
            console.error(error);
        }
    }

    useEffect(() => {
        handleGetBooks();
    },[]);

    
    return (
        bookList && 
        <div className="p-4">
            <div className="flex flex-row justify-between px-4">
                <SearchBar searchQuery={searchQuery} setSearchQuery={setSearchQuery} />
                <button className="border-2 border-green-500 bg-green-500 text-white font-semibold p-2 hover:bg-white hover:text-black rounded-lg" onClick={()=>handleOpenModalCreate()}>Add book</button>
            </div>
            <div className="flex flex-row flex-wrap w-full h-fit gap-6 mt-4 justify-center">
                {searchList.map((book: any) => (
                <BookCard book={book} handleOpenModalBorrow={handleOpenModalBorrow} handleDelete={handleDelete}  handleOpenModalUpdate={handleOpenModalUpdate}/>
            ))}
            </div>
            {/* {Modal for borrowing book} */}
            <Modal isShowModal={isShowModalBorrow}>
                <BorrowBookModal setIsShowModal={setIsShowModalBorrow}  handleCloseModal={handleCloseModalBorrow} handleSubmit={handleSubmitBorrow}/>
            </Modal>
            {/* {Modal for creating book} */}
            <Modal isShowModal={isShowModalCreate}>
                <CreateBookModal handleCloseModal={handleCloseModalCreate} handleSubmit={handleSubmitCreate}/>
            </Modal>
            {/* {Modal for updating book} */}
            <Modal isShowModal={isShowModalUpdate}>
                <UpdateBookModal handleCloseModal={handleCloseModalUpdate} handleSubmit={handleSubmitUpdate} book={currentBook!} />
            </Modal>
        </div>
    )
}
