//import './ChildComponent.css'

function ChildComponent({props}) {
  
  return (
    <>
      <p>This is the Child Component!</p>
      <span>Hello {props.name}! </span>
      <span>You are {props.age} years old!</span>
      <div>
        <input 
            type="text" 
            placeholder="Enter Farenheit" 
            className="border p-2 rounded w-full"
        />
        <button onClick = {props.changeFarValue}>
            Convert!
        </button>
      </div>
    </>
  )
}

export default ChildComponent