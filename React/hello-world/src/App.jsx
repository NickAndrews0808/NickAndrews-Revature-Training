import { use, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ChildComponent from './ChildComponent'

function App() {

  let [far, changeFarValue] = useState(0);
  let [cel, changeCelValue] = useState(0);


  return (
    <>
    <p>This is the Parent Component!</p>
    <ChildComponent name = "Bruh" age = {90021} />
    </>
  )
}

export default App
