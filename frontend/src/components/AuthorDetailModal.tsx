interface Author {
  authorId: number;
  portrait_url: string;
  name: string;
  nationality: string;
}

interface AuthorDetailModalProps {
  author: Author;
  handleCloseModal: () => void;
}

export default function AuthorDetailModal({ author,handleCloseModal }: AuthorDetailModalProps) {
 
  return (
    <div className="w-full h-full bg-opacity-50 bg-black flex justify-center items-center fixed top-0 left-0 z-50">
    <div className="bg-white p-6 rounded-lg w-3/4 md:w-1/2 h-auto">
      <div className="flex justify-between items-center">
        {/* Displaying the author's name */}
        <h3 className="text-2xl font-bold">{author.name}</h3>
        <button
          className="text-red-500 font-semibold"
          onClick={handleCloseModal}
        >
          X
        </button>
      </div>
      <div className="mt-4 flex flex-col items-center">
        {/* Displaying the author's image */}
        <img 
          src={author.portrait_url} 
          className="w-32 h-32 object-cover rounded-full" 
        />
        
        {/* Displaying the author's nationality */}
        <p className="text-lg mt-2">
          <strong>Nationality:</strong> {author.nationality}
        </p>
      </div>
    </div>
  </div>
);
};
 


// const AuthorDetailModal: React.FC<AuthorDetailModalProps> = ({ author, handleCloseModal }) => {
//   if (!author) return <div>No author data available.</div>; // Safeguard if no author is passed

//   return (
//     <div className="w-full h-full bg-opacity-50 bg-black flex justify-center items-center fixed top-0 left-0 z-50">
//       <div className="bg-white p-6 rounded-lg w-3/4 md:w-1/2 h-auto">
//         <div className="flex justify-between items-center">
//           {/* Displaying the author's name */}
//           <h3 className="text-2xl font-bold">{author.name}</h3>
//           <button
//             className="text-red-500 font-semibold"
//             onClick={handleCloseModal}
//           >
//             X
//           </button>
//         </div>
//         <div className="mt-4 flex flex-col items-center">
//           {/* Displaying the author's image */}
//           <img 
//             src={author.coverImageUrl || "https://i.ebayimg.com/images/g/AFcAAOSwtRdmNy6c/s-l1600.webp"} 
//             className="w-32 h-32 object-cover rounded-full" 
//           />
          
//           {/* Displaying the author's nationality */}
//           <p className="text-lg mt-2">
//             <strong>Nationality:</strong> {author.nationality}
//           </p>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default AuthorDetailModal;
