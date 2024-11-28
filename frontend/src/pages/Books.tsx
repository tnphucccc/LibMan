import axios from "axios";
import { useEffect, useState } from "react";

export default function Books() {  

    const [bookList, setBookList] = useState([]);

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

    useEffect(() => {
        handleGetBooks();
    },[]);
    
    return (
        <div className="p-4">
            <h2 className="text-center font-bold text-3xl">Book List</h2>
            <div className="flex flex-row flex-wrap w-full h-fit gap-4 mt-4">
                { bookList.map((book: any) => (
                <div key={book.id} className="border-2 border-black w-72 h-40 p-2 rounded-lg">
                    <h3 className="font-semibold text-base">{book.title}</h3>
                    <p className="text-sm">{book.publicationYear}</p>
                    <p className="text-sm">{book.authors[0].name}</p>
                    <p className="text-sm">{book.isbn}</p>
                    <div className="flex justify-end p-2">
                        <button className={`border-2 border-black p-2 text-base font-semibold rounded-lg bg-black text-white ${book.status == "AVAILABLE" && "hover:bg-white hover:text-black"}  ${book.status != "AVAILABLE" && "cursor-not-allowed opacity-50"}`} disabled = {book.status != "AVAILABLE"? true:false}>Borrow</button>
                    </div>
                </div>
            ))}
            </div>
            
        </div>
    )
}
