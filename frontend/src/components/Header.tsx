import { useLocation, useNavigate } from "react-router-dom"

export default function Header() {
    const navigate = useNavigate();
    const currPage = useLocation().pathname;

    const handleAuthors = () => {
        navigate('/Authors');
    }

    const handleRecord = () => {
        navigate('/Record');
    }

    const handleHome = () => {
        navigate('/');
    }

    const handleBooks = () => {
        navigate('/Books');
    }

  return (
    <div className={`w-full h-full bg-orange-500 flex justify-between items-center py-2 px-16`}>
        <div className='flex justify-center items-center gap-x-5 pl-[20px] hover:cursor-pointer' onClick={()=>handleHome()}>
            <div className="w-16 h-16 rounded-full border-4 border-black bg-white flex justify-center items-center">
                    <img src="./Image/hp1.png" className="h-8 w-8" alt="" />   
            </div>
            
            <div className="text-white text-lg font-bold w-10 ">
                <span>Library System </span>  
            </div>
            
        </div>

        <div className="flex gap-4">
            <button className="text-white font-bold rounded-lg border-2 border-white p-2 hover:bg-white hover:text-orange-500 text-base w-24" onClick={()=>handleBooks()}>
                    Books
            </button>

            <button className="text-white font-bold rounded-lg border-2 border-white p-2 hover:bg-white hover:text-orange-500 text-base w-24" onClick={()=>handleAuthors()}>
                    Authors
            </button>

            <button className="text-white font-bold rounded-lg border-2 border-white p-2 hover:bg-white hover:text-orange-500 text-base w-24" onClick={()=>handleRecord()}>
                    Record
            </button>

        </div>
  </div>
  )
}
