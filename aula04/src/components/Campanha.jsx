import React from 'react'
import styles from './Campanha.module.css'

const Campanha = (props) => {

    function defineMensagem(mes) {
        if (mes === "setembro") {
            return "Prevenção ao suicídio."
        } else if (mes === "outubro") {
            return "Concientização sobre o câncer de mama."
        } else {
            return "Prevenção e combate ao câncer de próstata."
        }
    }

    function defineCorDeFundo(mes) {
        if (mes === "setembro") {
            return styles.setembroClass
        } else if (mes === "outubro") {
            return styles.outubroClass
        } else {
            return styles.novembroClass
        }
    }

  return (
    <div className={defineCorDeFundo(props.mes)}>
        <p>{defineMensagem(props.mes)}</p>
    </div>
  )
}

export default Campanha