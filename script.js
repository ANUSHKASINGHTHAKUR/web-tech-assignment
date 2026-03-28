document.getElementById("userForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    let name = document.getElementById("name").value;
    let age = document.getElementById("age").value;
    
    if (age < 18) {
        alert("You must be at least 18 years old.");
    } else {
        document.getElementById("output").textContent = 
            `Hello ${name}, you are ${age} years old.`;
    }
});
