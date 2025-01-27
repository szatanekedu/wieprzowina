// Lista elementów tuszy wieprzowej
const data = [
  { id: 1, name: "Głowa wieprzowa", image: "/images/glowa.jpg" },
  { id: 2, name: "Karkówka", image: "/images/karkowka.jpg" },
  { id: 3, name: "Łopatka", image: "/images/lopatka.jpg" },
  { id: 4, name: "Schab", image: "/images/schab.jpg" },
  { id: 5, name: "Żeberka", image: "/images/zeberka.jpg" },
  { id: 6, name: "Polędwica", image: "/images/poledwica.jpg" },
  { id: 7, name: "Boczek", image: "/images/boczek.jpg" },
  { id: 8, name: "Szynka", image: "/images/szynka.jpg" },
  { id: 9, name: "Golonka", image: "/images/golonka.jpg" },
  { id: 10, name: "Nogi", image: "/images/nozki.jpg" },
  { id: 11, name: "Podgardle", image: "/images/podgardle.jpg" },
  { id: 12, name: "Ogony", image: "/images/ogony.jpg" },
  { id: 13, name: "Słonina", image: "/images/slonina.jpg" },
  { id: 14, name: "Pręga", image: "/images/prega.jpg" },
];

// Dynamiczne dodawanie obrazów i nazw
const imagesContainer = document.getElementById("images");
const namesContainer = document.getElementById("names");

data.forEach(item => {
  // Dodawanie zdjęć
  const img = document.createElement("img");
  img.src = item.image;
  img.alt = item.name;
  img.setAttribute("draggable", true);
  img.classList.add("draggable");
  img.dataset.name = item.name;
  imagesContainer.appendChild(img);

  // Dodawanie nazw
  const div = document.createElement("div");
  div.textContent = item.name;
  div.classList.add("droppable");
  div.dataset.name = item.name;
  namesContainer.appendChild(div);
});

// Funkcje przeciągania i upuszczania
let draggedElement = null;

imagesContainer.addEventListener("dragstart", (e) => {
  draggedElement = e.target;
  e.target.classList.add("dragging");
});

imagesContainer.addEventListener("dragend", (e) => {
  e.target.classList.remove("dragging");
});

namesContainer.addEventListener("dragover", (e) => {
  e.preventDefault();
});

namesContainer.addEventListener("drop", (e) => {
  e.preventDefault();
  const target = e.target;
  if (target.dataset.name === draggedElement.dataset.name) {
    target.style.backgroundColor = "#90EE90";
    target.textContent = "Dopasowane!";
  } else {
    target.style.backgroundColor = "#FFCCCB";
  }
});
