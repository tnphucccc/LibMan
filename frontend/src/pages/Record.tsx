import { useEffect, useState } from "react";
import { Book } from "./Books";
import axios from "axios";

export interface Record {
  borrowingId: number,
  bookId: number,
  borrowerId: number,
  borrowDate: string,
  dueDate: string,
  returnDate: string,
  status: string
}

export default function Record() {

  const [bookList, setBookList] = useState<Book[]>([]);
  const [recordList, setRecordList] = useState<Record[]>([]);

  const handleGetBooks = async () => {
    try {
            const res = await axios.get (import.meta.env.VITE_BASE_URL + '/books');
            if (res.status) {
                setBookList(res.data);
                console.log(res.data);
            }
        } catch (error) {
            console.error(error);
        }
  };

  const handleGetRecords = async () => {
    try {
      const res = await axios.get(import.meta.env.VITE_BASE_URL + '/borrowings');
      if (res.status) {
        setRecordList(res.data);
        console.log(res.data);
      }
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    handleGetBooks();
    handleGetRecords();
  }, []);

  return (
    <div>
      Record page
    </div>
  )
}
