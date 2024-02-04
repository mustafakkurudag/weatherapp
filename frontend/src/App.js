import { useState } from 'react';
import './App.css';
import Input from './component/Input';
import CurrentDate from './component/Date';

function App() {
  return (
    <div className='flex flex-col w-full bg-gradient-to-r from-blue-500 to-orange-300 h-screen bg-no-repeat bg-center bg-cover'>
      <div className='w-full'>
      <CurrentDate />
      </div>
      <div className='flex items-start justify-center pt-20'>
        <Input />
      </div>
    </div>
  );
}

export default App;
