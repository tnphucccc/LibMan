import { useRef } from "react";
import { IoMdClose } from "react-icons/io";
import { Author } from "../pages/Authors";

interface UpdateAuthorModalProps {
  handleCloseModal: () => void;
  handleSubmit: (author: Author) => void;
  author: Author;
}

export default function UpdateAuthorModal({handleCloseModal, handleSubmit, author,}: UpdateAuthorModalProps) {
  const nameRef = useRef<HTMLInputElement>(null);
  const nationalityRef = useRef<HTMLInputElement>(null);
  const portraitUrlRef = useRef<HTMLInputElement>(null);


  return (
    <div className="border-0 rounded-lg shadow-lg flex flex-col w-96 bg-white p-6">
      {/*header*/}
      <div className="flex items-center justify-between pb-4 pt-2 border-b-2 border-blueGray-200 rounded-t w-full">
        <h3 className="text-lg font-semibold">Updating Author</h3>
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
        <div className="flex flex-col text-sm mb-4">
          <label className="ml-3 opacity-50">Name</label>
          <input
            className="mt-1 h-10 w-full rounded-lg pl-3 border-2 border-black font-semibold"
            type="text"
            defaultValue={author.name}
            ref={nameRef}
          />
        </div>
        <div className="flex flex-col text-sm mb-4">
          <label className="ml-3 opacity-50">Nationality</label>
          <input
            className="mt-1 h-10 w-full rounded-lg pl-3 border-2 border-black font-semibold"
            type="text"
            defaultValue={author.nationality}
            ref={nationalityRef}
          />
        </div>
        <div className="flex flex-col text-sm mb-4">
          <label className="ml-3 opacity-50">Portrait URL</label>
          <input
            className="mt-1 h-10 w-full rounded-lg pl-3 border-2 border-black font-semibold"
            type="text"
            defaultValue={author.portraitUrl}
            ref={portraitUrlRef}
          />
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
          onClick={() =>
            handleSubmit({
              authorId: author.authorId,
              books: author.books,
              name: nameRef.current!.value,
              nationality: nationalityRef.current!.value,
              portraitUrl: portraitUrlRef.current!.value,
            })
          }
        >
          Update
        </button>
      </div>
    </div>
  );
}
