import { IoMdClose } from "react-icons/io";
import { Borrower } from "../pages/Borrowers";


interface BorrowerDetailModalProps {
  borrower: Borrower;
  handleCloseModal: () => void;
  bookList : any
}

export default function BorrowerDetailModal({ borrower, handleCloseModal, bookList }: BorrowerDetailModalProps) {
  return (
    <div className="bg-white rounded-lg w-[500px] h-full border border-gray-300 shadow-xl p-6 ">
      {/* Header Section */}
      <div className="flex items-center justify-between mb-2">
        <h3 className="text-3xl font-bold text-gray-800">Borrowed List</h3>
        <button
          className="text-gray-500 hover:text-red-500"
          onClick={handleCloseModal}
        >
          <IoMdClose size={24} />
        </button>
      </div>

      {/* Borrower Information */}
      <h3 className="text-lg font-semibold text-gray-700 mb-4">
          Borrower: <span className="text-gray-900">{borrower.name}</span>
      </h3>

      {/* Table Section */}
      <div className="relative overflow-x-auto w-full">
        <table className="w-full text-sm text-left text-gray-500 border border-gray-200">
          {/* Table Header */}
          <thead className="text-sm text-gray-700 uppercase bg-gray-100">
            <tr>
              <th className="px-6 py-3 text-center border border-gray-300">
                ID
              </th>
              <th className="px-6 py-3 text-center border border-gray-300">
                Book Title
              </th>
              <th className="px-6 py-3 text-center border border-gray-300">
                Borrowed Date
              </th>
              <th className="px-6 py-3 text-center border border-gray-300">
                Status
              </th>
            </tr>
          </thead>

          {/* Table Body */}
          <tbody>
            {borrower.borrowings.map((br) => (
              <tr
                className="bg-white hover:bg-gray-50 text-gray-700 text-sm"
                key={br.borrowingId}
              >
                <td className="px-6 py-4 text-center border border-gray-300 font-medium text-gray-900">
                  {br.borrowingId}
                </td>
                <td className="px-6 py-4 text-center border border-gray-300">
                  {
                    bookList.find(
                      (book: { bookId: number }) => book.bookId === br.bookId
                    )?.title
                  }
                </td>
                <td className="px-6 py-4 text-center border border-gray-300">
                  {br.borrowedDate}
                </td>
                <td
                  className={`px-6 py-4 text-center border border-gray-300 ${
                    br.status === "RETURNED"
                      ? "text-green-600 font-semibold"
                      : "text-red-600 font-semibold"
                  }`}
                >
                  {br.status}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

