import NavBar from "./components/Navbar/Navbar";
import AboutMe from "./components/AboutMe/AboutMe";
import Education from "./components/Education/Education";
import Experience from "./components/Experience/Experience";
import Projects from "./components/Projects/Projects";

export default function App() {
  return (
    <>
      <NavBar />
        <AboutMe />
        <Education />
        <Experience />
        <Projects />
    </>
  );
}