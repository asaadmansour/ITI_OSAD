var nameEl = document.getElementById("name");
var mobile = document.getElementById("mobile");
var email = document.getElementById("email");
var address = document.getElementById("address");
var title = document.getElementById("title");

var queryString = window.location.search;
var urlParams = new URLSearchParams(queryString);

nameEl.textContent = urlParams.get("name");
mobile.textContent = urlParams.get("mobile");
email.textContent = urlParams.get("email");
address.textContent = urlParams.get("address");
title.textContent = urlParams.get("title");
