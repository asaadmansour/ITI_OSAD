const themeToggle = document.getElementById('theme-toggle');

themeToggle.addEventListener('click', () => {
  document.documentElement.classList.toggle('dark');
});
const cardsContainer = document.querySelector(".cards");

const cardContent = {
  "ABOUT ME": `
    <div class="flex flex-col space-y-4 h-full justify-center">
      <div class="flex flex-col">
          <span class="text-green-400 dark:text-green-700 text-xs tracking-widest mb-1">LOCATION</span>
          <span class="text-md font-medium">Cairo, Egypt</span>
      </div>
      <div class="flex flex-col">
          <span class="text-green-400 dark:text-green-700 text-xs tracking-widest mb-1">ROLE</span>
          <span class="text-md font-medium">Backend-focused Software Engineer</span>
      </div>
      <div class="flex flex-col">
          <span class="text-green-400 dark:text-green-700 text-xs  tracking-widest mb-1">FOCUS</span>
          <span class="text-md font-medium">APIs • Databases • Clean Architecture</span>
      </div>
    </div>
  `,
  "EDUCATION": `
    <div class="flex flex-col space-y-6 text-sm w-full">
      <div>
        <div class="flex justify-between items-start w-full">
          <h4 class="text-sm font-bold text-green-400 dark:text-green-700 leading-tight w-3/4">Information Technology Institution (ITI)</h4>
          <span class="text-xs text-gray-500 whitespace-nowrap ml-2">10/24 – 06/25</span>
        </div>
        <p class="text-md text-white dark:text-black mt-1">Open Source Applications Development</p>
      </div>

      <div>
        <div class="flex justify-between items-start w-full">
          <h4 class="text-sm font-bold text-green-400 dark:text-green-700 leading-tight w-3/4">Arab Academy & Uni. of Northampton</h4>
          <span class="text-xs text-gray-500 whitespace-nowrap ml-2">09/21 – 06/25</span>
        </div>
        <p class="text-md text-white dark:text-black mt-1">B.A. in Business Informatics</p>
      </div>
    </div>
  `,
  "SKILLS": `
    <div class="flex flex-col space-y-3 h-full justify-center text-sm">
      
      <div class="flex flex-col">
          <span class="text-green-400 dark:text-green-700 text-sm font-bold tracking-widest mb-1">LANGUAGES</span>
          <span class="text-md text-white dark:text-black leading-relaxed break-words">Java, TypeScript, JavaScript (ES6+), SQL</span>
      </div>

      <div class="flex flex-col">
          <span class="text-green-400 dark:text-green-700 text-sm font-bold tracking-widest mb-1">BACKEND & APIS</span>
          <span class="text-md text-white dark:text-black leading-relaxed break-words">Spring Boot, Node.js, Express, Django, REST, GraphQL, OpenAPI</span>
      </div>

      <div class="flex flex-col">
          <span class="text-green-400 dark:text-green-700 text-sm font-bold tracking-widest mb-1">DATABASES & DEVOPS</span>
          <span class="text-md text-white dark:text-black leading-relaxed break-words">MySQL, PostgreSQL, MongoDB, Redis, Docker, Linux, Git</span>
      </div>

      <div class="flex flex-col">
          <span class="text-green-400 dark:text-green-700 text-sm font-bold tracking-widest mb-1">CONCEPTS</span>
          <span class="text-md text-white dark:text-black leading-relaxed break-words">Microservices, Clean Arch, DSA, Design Patterns, SOLID</span>
      </div>

    </div>
  `,
};

cardsContainer.addEventListener('click', (e) => {
  const card = e.target.closest('.card');
  if (!card) return;

  const contentSpan = card.querySelector('.content');
  const originalTitle = card.dataset.title;
  const detailedContent = cardContent[originalTitle] || "Content coming soon...";

  if (card.classList.contains('is-flipped')) {
    contentSpan.innerHTML = originalTitle;
    card.classList.remove('is-flipped', 'text-sm', 'items-start', 'justify-start', 'p-6', 'overflow-y-auto');
    card.classList.add('items-center', 'justify-center', 'text-3xl', 'font-bold');
  } else {
    contentSpan.innerHTML = detailedContent;
    card.classList.remove('items-center', 'justify-center', 'text-3xl', 'font-bold');
    card.classList.add('is-flipped', 'text-sm', 'items-start', 'justify-start', 'p-6', 'overflow-y-auto');
  }
});