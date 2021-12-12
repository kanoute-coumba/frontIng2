const previousBtn = document.getElementById('previousBtn');
const nextBnt = document.getElementById('nextBtn');
const content = document.getElementById('content');
const bullets = [...document.querySelectorAll('.bullet')];

const max_steps  = 4 ;
let currentStep = 1;

nextBtn.addEventListener('click', () =>{
const currentBullet = bullets[currentStep-1];
currentBullet.classList.add("completed");
currentStep++;
previousBtn.disabled = false;

if(currentStep == max_steps) {
nextBtn.disabled = true;
}
})

previousBtn.addEventListener('click', () => {
const previousBullet = bullets[currentStep - 2];
previousBullet.classList.remove('completed');
currentStep--;
nextBtn.disabled = false;

if(currentStep == 1) {
previousBtn.disabled = true;
}



})
