 function getUsers() {
    return fetch("https://jsonplaceholder.typicode.com/users")
                .then((res) => { 
                    if(!res.ok)
                        throw("Error in api request!");
                    return res.json()
                    }).then((jsonRes) => {
                        return jsonRes
                    }).catch((err) => console.log(err)) 
}
// let users = getUsers();
// users.then((users)=> (console.log(users)))
let namesDiv = document.getElementById("names");
getUsers().then((users) => {
    users.forEach((user) => {
        namesDiv.innerHTML += `
            <div class="box" data-user-id="${user.id}">
                <p class="boxText">${user.name}</p>
            </div>
        `;
    })
    let firstBox = document.querySelector(".box");
    firstBox.classList.add("selected");
    renderUsersParagraph(1);
})
async function getUsersParagraph(userId) {
    let res = await fetch(`https://jsonplaceholder.typicode.com/posts?userId=${userId}`);
    let data = await res.json();
    return data.map((obj)=> obj.title);
}
// let arr = getUsersParagraph(1);
// console.log(arr);
async function renderUsersParagraph(userId) {
    let usersParagraph = await getUsersParagraph(userId);
    let ul = document.getElementById("ul");
    ul.innerHTML = '';
    usersParagraph.forEach((paragraph) =>  {
        ul.innerHTML += `<li>${paragraph}</li>`;
    })
}


namesDiv.addEventListener("click", (e) => {
    let box = e.target.closest(".box"); 
    if (!box) return;
    
    let previousSelected = document.querySelector(".box.selected");
    if (previousSelected) {
        previousSelected.classList.remove("selected");
    }
    
    box.classList.add("selected"); 

    let userId = box.dataset.userId;
    renderUsersParagraph(userId);
});
