interface Book {
  bookId: number;
  coverImageUrl: string;
  title: string;
  publicationYear: number;
  authors: { name: string }[];
  isbn: string;
  status: string;
}

interface BookCardProps {
  book: Book;
  handleOpenModalBorrow: (bookId: number) => void;
  handleDelete: (bookId: number) => void;
  handleOpenModalUpdate: (book: Book) => void;
}

export default function BookCard({ book, handleOpenModalBorrow, handleDelete,  handleOpenModalUpdate }: BookCardProps) {


  return (
    <div key={book.bookId} className="border-2 border-black w-72 h-96 p-2 rounded-lg cursor-pointer" >
        <img src={book.coverImageUrl} className="w-full h-56"/>
        <h3 className="font-semibold text-base truncate">{book.title}</h3>
        <p className="text-sm">{book.publicationYear < 0? `${book.publicationYear.toString().substring(1,book.publicationYear.length)} BC`: book.publicationYear}</p>
        <p className="text-sm">{book.authors[0].name}</p>
        <p className="text-sm">{book.isbn}</p>
        <div className="flex justify-end gap-4 p-2">
            {book.status == "AVAILABLE" && <button className=" w-20 border-2 border-red-500 hover:bg-white hover:text-black p-2 font-semibold rounded-lg bg-red-500 text-white" onClick={()=>handleDelete(book.bookId)}>Delete</button>}
            <button className=" w-20 border-2 border-yellow-500 hover:bg-white hover:text-black p-2 font-semibold rounded-lg bg-yellow-500 text-white" onClick={()=>handleOpenModalUpdate(book)}>Edit</button>
            <button className={`w-20 border-2 border-blue-500 p-2 text-base font-semibold rounded-lg bg-blue-500 text-white ${book.status == "AVAILABLE" && "hover:bg-white hover:text-black"}  ${book.status != "AVAILABLE" && "cursor-not-allowed opacity-50"}`} disabled = {book.status != "AVAILABLE"? true:false} onClick={() => handleOpenModalBorrow(book.bookId)}>Borrow</button>
        </div>
    </div>
  )
}