export default function Experience() {
    return (
        <section id="experience" className="section-spacing">
            <div className="container-custom">
                <h2 className="text-3xl md:text-4xl font-bold text-blue-600 mb-12">
                    Experience
                </h2>
                <div className="flex flex-col gap-8">
                    
                    <div className="border-l-4 border-blue-600 pl-6 py-2">
                        <div className="flex flex-col md:flex-row md:justify-between md:items-start mb-1">
                            <h3 className="text-xl font-bold text-gray-800">Java Software Developer – Intern</h3>
                            <span className="text-blue-600 font-medium whitespace-nowrap">Jul 2024 – Aug 2024</span>
                        </div>
                        <div className="text-gray-600 font-medium mb-3">Information Technology Institute (ITI) | Remote</div>
                        <ul className="list-disc list-outside ml-5 text-gray-700 space-y-2">
                            <li>Built a multi-module Java application applying SOLID principles, design patterns (Factory, Singleton, Observer), and layered architecture with JUnit/Mockito test coverage</li>
                        </ul>
                    </div>

                    <div className="border-l-4 border-blue-600 pl-6 py-2">
                        <div className="flex flex-col md:flex-row md:justify-between md:items-start mb-1">
                            <h3 className="text-xl font-bold text-gray-800">Frontend Developer – Intern</h3>
                            <span className="text-blue-600 font-medium whitespace-nowrap">Aug 2023 – Sep 2023</span>
                        </div>
                        <div className="text-gray-600 font-medium mb-3">Queen Tech Solutions | Cairo, Egypt</div>
                        <ul className="list-disc list-outside ml-5 text-gray-700 space-y-2">
                            <li>Developed a responsive gym website using JavaScript and Tailwind CSS; refactored 500+ lines of code, reducing load times by 15% and resolving 5+ UI bugs</li>
                        </ul>
                    </div>

                    <div className="border-l-4 border-blue-600 pl-6 py-2">
                        <div className="flex flex-col md:flex-row md:justify-between md:items-start mb-1">
                            <h3 className="text-xl font-bold text-gray-800">Business Data Analyst – Intern</h3>
                            <span className="text-blue-600 font-medium whitespace-nowrap">Jul 2022 – Aug 2022</span>
                        </div>
                        <div className="text-gray-600 font-medium mb-3">3S Software | Cairo, Egypt</div>
                        <ul className="list-disc list-outside ml-5 text-gray-700 space-y-2">
                            <li>Authored 15+ optimized SQL queries for incident trend reports and designed 3 Power BI dashboards visualizing traffic patterns for data-driven policy decisions</li>
                        </ul>
                    </div>

                </div>
            </div>
        </section>
    );
}
