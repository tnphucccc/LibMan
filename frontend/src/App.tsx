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
    <div className='h-screen bg-teal-300'>
      <h1 className='text-3xl text-black bg-red-400 text-left font-bold'>Counter test</h1>
      <span className='text-2xl font-semibold ml-2'>{count}</span>
      <div className="flex flex-row gap-4">
        <button className='text-2xl text-white p-2 bg-slate-600' onClick={() => handleIncrement()}>
          Increase
        </button>
        <button className='text-2xl text-black p-2 bg-red-500' onClick={() => handleDecrement()}>
          Decrease
        </button>
        <button className='text-2xl text-white p-2 bg-slate-600' onClick={() => handleReset()}>
          Reset
        </button>
      </div>
      
    </div>
  )
}

export default App
