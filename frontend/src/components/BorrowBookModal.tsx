import { IoMdClose } from "react-icons/io";

import { useRef } from "react";

interface BorrowBookModalProps {
  setIsShowModal: (isShow: boolean) => void;
  handleCloseModal: () => void;
  handleSubmit: ({id,date}:{id:number, date:Date}) => void;
}

export default function BorrowBookModal({ setIsShowModal, handleCloseModal, handleSubmit }: BorrowBookModalProps) {

    const idRef = useRef<HTMLInputElement>(null);
    const dateRef = useRef<HTMLInputElement>(null);

  return (
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
            <div className="flex flex-col text-sm mb-4">
                <label className="ml-3 opacity-50">Borrower ID</label>
                <input className="mt-1 h-10 w-full rounded-lg pl-3 border-2 border-black font-semibold"
                type="text" ref={idRef}/>
            </div>
            <div className="flex flex-col text-sm">
                <label className="ml-3 opacity-50">Due date</label>
                <input className="mt-1 h-10 w-full rounded-lg pl-3 border-2 border-black font-semibold"
                type="date" ref={dateRef}/>
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
            onClick={() => handleSubmit({id: parseInt(idRef.current!.value), date: new Date(dateRef.current!.value)})}
            >
            Create
            </button>
        </div>
    </div>
  )
}
