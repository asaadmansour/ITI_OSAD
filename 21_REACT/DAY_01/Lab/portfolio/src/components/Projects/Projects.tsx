export default function Projects() {
    return (
        <section id="projects" className="section-spacing bg-gray-50">
            <div className="container-custom">
                <h2 className="text-3xl md:text-4xl font-bold text-blue-600 mb-12">
                    Projects
                </h2>
                <div className="grid grid-cols-1 md:grid-cols-2 gap-8">


                    <div className="bg-white p-8 rounded-xl shadow-sm hover:shadow-md transition-shadow border border-gray-100 flex flex-col h-full">
                        <div className="flex justify-between items-start mb-4">
                            <h3 className="text-2xl font-bold text-gray-800">ChapterOne</h3>
                            <span className="bg-blue-100 text-blue-800 text-xs font-semibold px-2.5 py-0.5 rounded">2026</span>
                        </div>
                        <p className="text-sm text-gray-500 font-medium mb-4">Node.js, Express.js, MongoDB, Angular, JWT, CI/CD</p>
                        <ul className="list-disc list-outside ml-4 text-gray-700 space-y-2 text-sm flex-grow">
                            <li>Architected RESTful API with JWT access/refresh token rotation, role-based authorization (admin, seller, buyer), and configurable rate limiting middleware</li>
                            <li>Implemented transactional order processing with atomic stock validation, a review/rating system, and Joi schema validation across all endpoints</li>
                            <li>Configured GitHub Actions CI/CD pipeline for automated linting and test execution on every push and pull request</li>
                        </ul>
                    </div>

                    <div className="bg-white p-8 rounded-xl shadow-sm hover:shadow-md transition-shadow border border-gray-100 flex flex-col h-full">
                        <div className="flex justify-between items-start mb-4">
                            <h3 className="text-2xl font-bold text-gray-800">Connvia</h3>
                            <span className="bg-blue-100 text-blue-800 text-xs font-semibold px-2.5 py-0.5 rounded">2025</span>
                        </div>
                        <p className="text-sm text-gray-500 font-medium mb-4">Node.js, Express.js, React, MySQL, Stripe API, JWT</p>
                        <ul className="list-disc list-outside ml-4 text-gray-700 space-y-2 text-sm flex-grow">
                            <li>Developed multi-role backend APIs (vendors, organizers, attendees) with Stripe payment integration, MySQL connection pooling, rate limiting, and Helmet security headers</li>
                        </ul>
                    </div>

                </div>
            </div>
        </section>
    );
}
