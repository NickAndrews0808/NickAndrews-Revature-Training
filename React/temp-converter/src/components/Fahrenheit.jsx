function Fahrenheit({fahrenheit, setFahrenheit, convertFtoC}) {

    function handleChange(e) {
        setFahrenheit(e.target.value);
    }

    return (
        <>
            <div>
                <label>Fahrenheit: </label>
                <input type="number"  value={fahrenheit} onChange = {handleChange} placeholder="Enter Fahrenheit Here" />
                <button onClick={convertFtoC}>Convert Fahrenheit to Celsius</button>
            </div>
        </>
    );
}
export default Fahrenheit;