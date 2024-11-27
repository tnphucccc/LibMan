import { useNavigate } from "react-router-dom"

export default function Header() {
    const navigate = useNavigate();

    const handleBorrow = () => {
        navigate('/Borrow');
    }

    const handleReturn = () => {
        navigate('/Return');
    }

    const handleHome = () => {
        navigate('/');
    }

  return (
    <div className='w-full h-full bg-orange-500 flex justify-between items-center py-2 px-16'>
        <div className='flex justify-center items-center gap-x-5 pl-[20px] hover:cursor-pointer' onClick={()=>handleHome()}>
            <div className="w-[40px] h-[40px] rounded-full border-4 border-black bg-white flex justify-center items-center">
                    <img src="./Image/hp1.png" className="h-[20px] w-[20px]" alt="" />   
            </div>
            
            <div className="text-white text-lg font-bold w-10 ">
                <span>Library System </span>  
            </div>
            
        </div>

        <div className="flex gap-4">
            <button className="text-white font-bold rounded-lg border-2 border-white p-2 hover:bg-white hover:text-orange-500 text-base" onClick={()=>handleBorrow()}>
                    Borrow Book
            </button>

            <button className="text-white font-bold rounded-lg border-2 border-white p-2 hover:bg-white hover:text-orange-500 text-base" onClick={()=>handleReturn()}>
                    Return Book
            </button>

        </div>
  </div>
  )
}
