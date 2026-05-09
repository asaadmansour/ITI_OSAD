export default function Education() {
    return (
        <section id="education" className="section-spacing bg-gray-50">
            <div className="container-custom">
                <h2 className="text-3xl md:text-4xl font-bold text-blue-600 mb-12">
                    Education
                </h2>
                <div className="flex flex-col gap-8">
                    <div className="bg-white p-6 rounded-lg shadow-sm border border-gray-100">
                        <div className="flex flex-col md:flex-row md:justify-between md:items-start mb-2">
                            <h3 className="text-xl font-bold text-gray-800">Information Technology Institute (ITI)</h3>
                            <span className="text-blue-600 font-medium">Oct 2025 – Present</span>
                        </div>
                        <div className="text-gray-600 mb-2">Cairo, Egypt</div>
                        <p className="text-gray-700 font-medium">9-Month Professional Diploma, Open Source Applications Development</p>
                    </div>

                    <div className="bg-white p-6 rounded-lg shadow-sm border border-gray-100">
                        <div className="flex flex-col md:flex-row md:justify-between md:items-start mb-2">
                            <h3 className="text-xl font-bold text-gray-800">University of Northampton & Arab Academy for Science and Technology</h3>
                            <span className="text-blue-600 font-medium whitespace-nowrap">Sep 2021 – Jun 2025</span>
                        </div>
                        <div className="text-gray-600 mb-2">Cairo, Egypt</div>
                        <p className="text-gray-700 font-medium">B.A. Business Informatics (Dual Degree) – GPA: 3.72/4.0</p>
                    </div>
                </div>
            </div>
        </section>
    );
}