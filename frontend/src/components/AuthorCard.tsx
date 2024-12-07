interface Author {
  authorId: number;
  portraitUrl: string;
  name: string;
  nationality: number;
  books: { title: string; coverImageUrl: string; bookId: number }[];
}

interface AuthorCardProps {
  author: Author;
  handleOpenAuthorDetail: (author: Author) => void;
  handleOpenModalUpdate: (author: Author) => void;
  handleDelete: (authorId: number) => void;

}

export default function AuthorCard({ author, handleOpenAuthorDetail , handleDelete,  handleOpenModalUpdate }: AuthorCardProps) { 

  return (
    <div key={author.authorId} className="bg-gray-200 border-2 border-black w-72 h-96 p-2 rounded-lg cursor-pointer hover:border-orange-500 hover:bg-gray-100" >
      <div onClick={() => handleOpenAuthorDetail(author)}>
        <img src={author.portraitUrl} className="w-full h-56 rounded-lg" />
        <h3 className="font-semibold text-xl truncate flex justify-center mt-4">{author.name}</h3>
      </div>
      <div className="flex justify-center gap-4 mt-8">
          <button className="w-20 border-2 border-red-500 hover:bg-white hover:text-black p-2 font-semibold rounded-lg bg-red-500 text-white" onClick={()=>handleDelete(author.authorId)}>Delete</button>
          <button className=" w-20 border-2 border-yellow-500 hover:bg-white hover:text-black p-2 font-semibold rounded-lg bg-yellow-500 text-white" onClick={()=>handleOpenModalUpdate(author)}>Edit</button>
      </div>
    </div>
  );
}
