const mediaAprovado = 7;
const notas = [8.00, 9.00, 1.00];

console.log(`A primeira nota é: ${notas[0]}`);
console.log(`A segunda nota é: ${notas[1]}`);
console.log(`A terceira nota é: ${notas[2]}`);

var media = (notas[0]+notas[1]+notas[2])/notas.length;

console.log(`A média foi: ${media}`);

if (media  >= mediaAprovado) {
    console.log("APROVADO");
} else {
    console.log("REPROVADO");
}