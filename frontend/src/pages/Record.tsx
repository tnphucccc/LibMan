import { useState } from "react";
import { Book } from "./Books";

export interface Record {
  borrowingId: number,
  bookId: number,
  borrowerId: number,
  borrowDate: string,
  dueDate: string,
  createAt: string,
  updateAt: string,
  status: string
}

export default function Record() {

  const [bookList, setBookList] = useState<Book[]>([]);
  const [recordList, setRecordList] = useState<Book[]>([]);

  return (
    <div>
      Record page
    </div>
  )
}
