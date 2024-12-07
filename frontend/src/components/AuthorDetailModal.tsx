import { IoMdClose } from "react-icons/io";
import { Author } from "../pages/Authors";

interface AuthorDetailModalProps {
  author: Author;
  handleCloseModal: () => void;
}

export default function AuthorDetailModal({
  author,
  handleCloseModal,
}: AuthorDetailModalProps) {
  return (
    <div  key={author.authorId} className="bg-white rounded-3xl w-[600px] h-[400px] border-2 border-black flex">
        <div className="w-[250px] flex flex-col items-center justify-center gap-y-4">
        <       img src={author.portraitUrl} className="w-32 h-32 object-cover rounded-full"/>
                <h3 className="text-xl font-bold text-center">{author.name}</h3>
                <p className="text-base"> <strong>Nationality:</strong> {author.nationality} </p>
        </div>
        <div className="w-[350px] flex flex-col gap-y-4">
          <div className="h-10 flex justify-end mr-10 mt-5">
            <button className="text-red-500 font-semibold" onClick={handleCloseModal}> <span className="text-lg">
                <IoMdClose />
            </span> </button>
          </div>
          <div className="text-center ml-5 w-full px-4">
                  <h4 className="text-xl font-semibold">Works</h4>
                  <ul className="list-disc list-inside mt-2 w-full">
                    {author.books.map((book) => (
                      <ul key={book.id} className="text-base truncate">
                        <p>{book.title}</p>
                      </ul>
                    ))}
                  </ul>
            </div>
        </div>


    </div>
  );
}
