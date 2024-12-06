import { useRef } from "react";
import { IoMdClose } from "react-icons/io";

interface ReturnBookModalProps {
  handleCloseModal: () => void;
  handleSubmit: (date : string) => void;
}

export default function ReturnBookModal({ handleCloseModal, handleSubmit }: ReturnBookModalProps) {

    const dateRef = useRef<HTMLInputElement>(null);

  return (
    <div className="border-0 rounded-lg shadow-lg flex flex-col w-96 bg-white p-6">
        {/*header*/}
        <div className="flex items-center justify-between pb-4 pt-2 border-b-2 border-blueGray-200 rounded-t w-full">
            <h3 className="text-lg font-semibold">Updating book</h3>
            <button
            className="border-0"
            onClick={() => handleCloseModal()}
            >
            <span className="text-lg">
                <IoMdClose />
            </span>
            </button>
        </div>
        {/*end header*/}
        <div className="w-full mt-4">
            <div className="flex flex-col text-sm">
                <label className="ml-3 opacity-50">Return date</label>
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
            onClick={() => handleSubmit(dateRef.current?.value || "")}
            >
            Update
            </button>
        </div>
    </div>
  )
}
