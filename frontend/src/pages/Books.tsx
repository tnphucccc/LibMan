import axios from "axios";
import { useEffect, useRef, useState } from "react";
import Modal from "../components/Modal";
import { IoMdClose } from "react-icons/io";

export default function Books() {  

    const [bookList, setBookList] = useState([]);
    const [isShowModal, setIsShowModal] = useState(false);
    const idRef = useRef<HTMLInputElement>(null);

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

    const handleOpenModal = () => {
        setIsShowModal(true);
    };

    const handleCloseModal = () => {
        setIsShowModal(false);
    };

    const handleSubmit = () => {
        console.log(idRef.current?.value);
    }

    useEffect(() => {
        handleGetBooks();
    },[]);
    
    return (
        <div className="p-4">
            <h2 className="text-center font-bold text-3xl">Book List</h2>
            <div className="flex flex-row flex-wrap w-full h-fit gap-4 mt-4 justify-center">
                { bookList.map((book: any) => (
                <div key={book.id} className="border-2 border-black w-72 h-96 p-2 rounded-lg">
                    <img src="https://marketplace.canva.com/EAFfSnGl7II/2/0/1003w/canva-elegant-dark-woods-fantasy-photo-book-cover-vAt8PH1CmqQ.jpg" className="w-full h-56"/>
                    <h3 className="font-semibold text-base truncate">{book.title}</h3>
                    <p className="text-sm">{book.publicationYear < 0? `${book.publicationYear.toString().substring(1,book.publicationYear.length)} BC`: book.publicationYear}</p>
                    <p className="text-sm">{book.authors[0].name}</p>
                    <p className="text-sm">{book.isbn}</p>
                    <div className="flex justify-end p-2">
                        <button className={`border-2 border-black p-2 text-base font-semibold rounded-lg bg-black text-white ${book.status == "AVAILABLE" && "hover:bg-white hover:text-black"}  ${book.status != "AVAILABLE" && "cursor-not-allowed opacity-50"}`} disabled = {book.status != "AVAILABLE"? true:false} onClick={() => handleOpenModal()}>Borrow</button>
                    </div>
                </div>
            ))}
            </div>
            {/* {Modal for borrowing book} */}
            <Modal isShowModal={isShowModal}>
                <div className="border-0 rounded-lg shadow-lg flex flex-col w-96 bg-white p-6">
                    {/*header*/}
                    <div className="flex items-center justify-between pb-4 pt-2 border-b-2 border-blueGray-200 rounded-t w-full">
                        <h3 className="text-lg font-semibold">Borrowing</h3>
                        <button
                        className="border-0"
                        onClick={() => setIsShowModal(false)}
                        >
                        <span className="text-lg">
                            <IoMdClose />
                        </span>
                        </button>
                    </div>
                    {/*end header*/}
                    <div className="w-full mt-4">
                        <div className="flex flex-col text-sm">
                            <label className="ml-3 opacity-50">Borrower ID</label>
                            <input className="mt-1 h-10 w-full rounded-lg pl-3 border-2 border-black font-semibold"
                            type="text" ref={idRef}/>
                        </div>
                    </div>
                    <div className="flex justify-end gap-2 mt-4">
                        <button
                        type="button"
                        className=" bg-red-500 text-sm font-semibold text-white p-2 rounded-lg w-20"
                        onClick={() => handleCloseModal()}
                        >
                        Cancel
                        </button>
                        <button
                        type="button"
                        className=" bg-green-500 text-sm font-semibold text-white p-2 rounded-lg w-20"
                        onClick={() => handleSubmit()}
                        >
                        Create
                        </button>
                    </div>
                </div>
            </Modal>
        </div>
    )
}
