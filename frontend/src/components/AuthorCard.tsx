interface Author {
  authorId: number;
  portrait_url: string;
  name: string;
  nationality: number;
  books: { name: string }[];
}

interface AuthorCardProps {
  author: Author;
  handleOpenAuthorDetail: (authorId: number) => void;
  handleOpenModalUpdate: (author: Author) => void;
  handleDelete: (authorId: number) => void;

}

export default function AuthorCard({ author, handleOpenAuthorDetail , handleDelete,  handleOpenModalUpdate }: AuthorCardProps) {
 
  return (
    <div key={author.authorId} className="bg-gray-200 border-2 border-black w-72 h-96 p-2 rounded-lg cursor-pointer hover:border-orange-500 hover:bg-gray-100"onClick={() => handleOpenAuthorDetail(author.authorId)} >
      <img src={author.portrait_url} className="w-full h-56" />
      <h3 className="font-semibold text-2xl truncate flex justify-center pt-10">{author.name}</h3>
      <div className="flex justify-center gap-4 p-2">
          <button className="w-20 border-2 border-red-500 hover:bg-white hover:text-black p-2 font-semibold rounded-lg bg-red-500 text-white" onClick={()=>handleDelete(author.authorId)}>Delete</button>
          <button className=" w-20 border-2 border-yellow-500 hover:bg-white hover:text-black p-2 font-semibold rounded-lg bg-yellow-500 text-white" onClick={()=>handleOpenModalUpdate(author)}>Edit</button>
      </div>
    </div>
  );
}
