import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Celsius from './components/Celsius'
import Fahrenheit from './components/Fahrenheit'

function App() {

  const [celsius, setCelsius] = useState(0);
  const [fahrenheit, setFahrenheit] = useState(32);

  // Need functions to do the conversions here
    function convertCtoF() {
        let f =  celsius * (9/5) + 32;
        setFahrenheit(f);
    }

    function convertFtoC() {
        let c = (fahrenheit - 32) * (5/9);
        setCelsius(c);
    }

    // Functions that look for change
    function handleCelsiusChange(newCelsius) {
        setCelsius(newCelsius);
    }

    function handleFahrenheitChange(newFahrenheit) {
        setFahrenheit(newFahrenheit);
    }

  return (
    <>
      <h1>Temperature Converter</h1>
      <h1>F: {fahrenheit}° C: {celsius}°</h1>
      <Fahrenheit fahrenheit={fahrenheit} setFahrenheit={handleFahrenheitChange} convertFtoC={convertFtoC} />
      <Celsius celsius={celsius} setCelsius={handleCelsiusChange} convertCtoF={convertCtoF} />
    </>
  )
}

export default App