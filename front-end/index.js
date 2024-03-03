
/*  temporal deadzone : temporal deadzone is the time from let and const variale memory allocation to variable
     initialization
    Block  : { 
        these paranthesis create a block space and allow us to bundle multiple statement and 
        with help of block we can run multiple statement instead of the single statement with if, while, etc
    }

    blocked scope and shadowing
    inlegal shadowing global let a can not be shadowed by var a but var a can be shadowed by let a / const a 
    but it will not change the value of var a

    blocked scope: let/const has diffrent memory alocation and if it's declared inside a block it will be 
    accessible in that block only
    block also has lexical environment which mean child block will be able to access memory of parent block

    shadowing : variable declared out of block and again declared inside block while accessing same variable inside 
    block varible accessed will be which declared inside box and even it's changes values of variable out side 
    block in case of var type variable but not in let or const

    ********Code for Blocked scope and shadowing
    var a= 100;
    let b =100;
    {
        let a = 10;       // shadows the global var a and modifies it's value from inside the 
        let b =20           // b also shadows the let b of global but it's can not change value of
                            // global b cause they both exist in diffrent block same for const
        const c =30;
        console.log(a);
        console.log(b);
        console.log(c);
    }
    console.log(a);
    console.log(b);
____________________________________________________________
    Closure in JS

*/
function outest(){
    function outer(x){
   
        function inner(){
            console.log(a, x);
        }
        const a= 10;
        return inner;
    }
    return outer;
}


var call = outest("Hello world!!");
call()();

function encapsulation(){
    let dost ="let's play";
    let count = 0; 
    this.incrementValue = ()=>{
        count++;
        console.log(count,dost);
    } 

    this.decrementValue = ()=>{
        count--;
        console.log(count,dost);
    }
}

let trial = new encapsulation();
trial.incrementValue();
trial.decrementValue();
let trial2 = new encapsulation();
trial2.incrementValue();
trial2.incrementValue();
trial2.incrementValue();
trial2.incrementValue();
