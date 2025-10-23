function Celsius({celsius, setCelsius, convertCtoF}) {
    function handleChange(e) {
        setCelsius(e.target.value);
    }

    return (
        <>
            <div>
                <label>Celsius: </label>
                <input type="number"  value={celsius} onChange = {handleChange} placeholder="Enter Celsius Here" />
                <button onClick={convertCtoF}>Convert Celsius to Fahrenheit</button>
            </div>
        </>
    );
}
export default Celsius;