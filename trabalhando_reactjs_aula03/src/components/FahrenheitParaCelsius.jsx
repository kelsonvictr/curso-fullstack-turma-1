import React from 'react'

const FahrenheitParaCelsius = (props) => {
    let celsius = (props.temperatura - 32) * 5/9;
  return (
    <div>
        {props.temperatura} °F será {celsius} °C
    </div>
  )
}

export default FahrenheitParaCelsius