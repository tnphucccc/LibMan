import { IoMdClose } from "react-icons/io";

interface Author {
  authorId: number;
  portraitUrl: string;
  name: string;
  nationality: string;
  books: { title: string; coverImageUrl: string; bookId: number }[];
}

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
                      <ul key={book.bookId} className="text-base truncate">
                        <p>{book.title}</p>
                      </ul>
                    ))}
                  </ul>
            </div>
        </div>


    </div>
  );
}


{/* <div
      key={author.authorId}
      className="w-full h-full bg-opacity-50 bg-black flex justify-center items-center fixed top-0 left-0 z-50"
    >
      <div className="bg-white p-6 rounded-3xl w-[2000px] md:w-1/2 h-auto border-[5px] border-orange-700 flex flex-col gap-y-10">
        <div className="flex justify-end"><button className="text-red-500 font-semibold" onClick={handleCloseModal}> X </button></div>
        
        <div className="flex">
            <div className="w-">
                <img src={author.portraitUrl} className="w-32 h-32 object-cover rounded-full"/>
                <h3 className="text-2xl font-bold">{author.name}</h3>
                <p className="text-lg mt-2"> <strong>Nationality:</strong> {author.nationality} </p>

            </div>
            <div className="w-2/3">
                <div className="mt-4">
                <h4 className="text-xl font-semibold">Books List:</h4>
                <ul className="list-disc list-inside mt-2">
                  {author.books.map((book) => (
                    <li key={book.bookId} className="text-lg">
                      {book.title}
                    </li>
                  ))}
                </ul>
              </div>
            </div>


        </div>
       
      </div>
    </div> */}
