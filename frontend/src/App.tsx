import './App.css'
import { useDispatch, useSelector } from 'react-redux'
import { AppDispatch, RootState } from './store/Store'
import { decreaseCount, increaseCount, resetCount } from './store/actions/CounterActions';

function App() {
  const {count} = useSelector(((state: RootState) => state.CounterStore));
  const dispatch = useDispatch<AppDispatch>();

  const handleIncrement = () => {
    dispatch (increaseCount());
  };

  const handleDecrement = () => {
    dispatch (decreaseCount());
  };

  const handleReset = () => {
    dispatch (resetCount());
  }

  return (
  //   <div className='h-screen'>
  //     <h1 className='text-3xl text-black bg-blue-500 text-left font-bold h-[150px] flex justify-center'>Counter test</h1>
  //     <span className='text-2xl font-semibold ml-2'>{count}</span>
  //     <div className="flex flex-row gap-4">
  //       <button className='text-2xl text-black p-2 bg-yellow-200' onClick={() => handleIncrement()}>
  //         Increase
  //       </button>
  //       <button className='text-2xl text-black p-2 bg-red-900' onClick={() => handleDecrement()}>
  //         Decrease
  //       </button>
  //       <button className='text-2xl text-white p-2 bg-slate-600' onClick={() => handleReset()}>
  //         Reset
  //       </button>
  //     </div>
  // </div>


  <div>
  {/* Nav bar */}
  <div className='w-screen h-[125px] bg-orange-500 flex justify-between items-center'>

  <div className='flex justify-center items-center gap-x-5 pl-[20px]'>
      <div className="w-[80px] h-[80px] rounded-full border-4 border-black bg-white flex justify-center items-center">
              <img src="./Image/hp1.png"
          className="h-[40px] w-[40px]"
          alt="" />   
      </div>
      
      <div className="text-white text-3xl font-bold w-10 ">
          <span>Library System </span>  
      </div>
      
  </div>

  <div className="pr-[30px] flex gap-4">
      <button className="text-white font-bold rounded-[15px] border-[3px] border-white px-2 py-2 hover:bg-white hover:text-orange-500">
              Borrow Book
      </button>

      <button className="text-white font-bold rounded-[15px] border-[3px] border-white px-2 py-2 hover:bg-white hover:text-orange-500">
              Return Book
      </button>

  </div>
  </div>
  {/*End nav bar */}

  {/* Body1*/}

  <div className='relative h-[400px] w-screen'>
    <img src="./Image/hp3.jpg" className='h-[400px] w-screen object-cover' alt="" />
  
    <div className='absolute inset-0 px-20 py-20  bg-black bg-opacity-60 '>
      <div className='w-[500px]'>
        <span className='text-white text-5xl font-bold'>Library Management System</span>
      </div>
      
      <p className='text-white text-xl pt-[40px]'>A software that helps organize and manage the operations of a library</p>
    </div>
</div>

{/* Body2*/}
<div className='h-screen w-screen bg-gray-200 flex flex-col pt-10 gap-y-10'>
    
    <h1 className='text-3xl text-black text-center'>Introduction</h1>

    <div className='flex flex-row text-center justify-center gap-x-[100px]'>
        <div className='w-[500px] flex flex-col gap-y-4'>
            <h2 className='text-xl font-bold text-orange-600'>Our Project</h2>
            <p>Our LMS (Library Management System) is a software that helps manage library resources, including cataloging, borrowing, returning, and circulation tracking. This software supports the systematic and accurate management of library operations, making it easy to store book information and track the status of borrowed books</p>

        </div>

        <div className='w-[500px] flex flex-col gap-y-4'>
            <h2 className='text-xl font-bold text-orange-600'>Purposes</h2>
            <div className='flex flex-col gap-y-4'>
              <ul>Streamline information retrieval: Provide a user-friendly interface that enables readers to quickly locate and access desired books.</ul>
              <ul>Optimize resource management: Assist librarians in managing inventory, tracking circulation, and identifying popular materials</ul>
            </div>
            
        </div>

    </div>

    <h1 className='text-3xl text-black text-center'>Team Members</h1>
    
    <div className='flex justify-center gap-x-[200px]'>
      <ol className="list-decimal pl-9 flex flex-col  gap-y-1 ">
        <li>Nguyen Mach Khang Huy</li>
        <li>Tran Nguyen Phuc</li>
        <li>Tran Quoc Bao</li>
        <li>Nguyen Minh Viet</li>
        <li>Bui Cong Vinh</li>
        <li>Nguyen Bach Dong Phuong</li>
        <li>Nguyen Thi Quynh Nga</li>
        <li>Le Minh Duy</li>
      </ol>

      <ul className='flex flex-col gap-y-1'>
        <li>Team Leader</li>
        <li>Vice Leader</li>
        <li>Team Member</li>
        <li>Team Member</li>
        <li>Team Member</li>
        <li>Team Member</li>
        <li>Team Member</li>
        <li>Team Member</li>
      </ul>
        
    </div>

</div>

{/*End Body2*/}

</div>
  )
}

export default App
