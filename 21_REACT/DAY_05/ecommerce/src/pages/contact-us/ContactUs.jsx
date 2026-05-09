import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import NavBar from "../../components/nav-bar/NavBar";

const initialValues = {
    firstName: "",
    lastName: "",
    phone: "",
    email: "",
    message: "",
};

const contactSchema = Yup.object({
    firstName: Yup.string().required("First name is required"),
    lastName: Yup.string().required("Last name is required"),
    phone: Yup.string()
        .matches(/^[0-9+\s\-()]{7,15}$/, "Invalid phone number")
        .required("Phone number is required"),
    email: Yup.string().email("Invalid email").required("Email is required"),
    message: Yup.string().min(10, "Message must be at least 10 characters").required("Message is required"),
});

export default function ContactUs() {
    return (
        <>
            <NavBar />
            <div className="min-h-screen bg-gray-50 pt-16 flex items-center justify-center px-4 py-10">
                <div className="w-full max-w-md bg-white rounded-2xl shadow-sm p-8">
                    <div className="mb-8">
                        <h1 className="text-2xl font-bold text-gray-800">Contact Us</h1>
                        <p className="text-sm text-gray-500 mt-1">Fill in the form below and we'll get back to you</p>
                    </div>
                    <Formik
                        initialValues={initialValues}
                        validationSchema={contactSchema}
                        onSubmit={(values) => {
                            console.log(values);
                        }}
                    >
                        <Form className="flex flex-col gap-5">
                            <div className="flex gap-3">
                                <div className="flex flex-col gap-1 flex-1">
                                    <label htmlFor="firstName" className="text-sm font-medium text-gray-700">
                                        First Name
                                    </label>
                                    <Field
                                        id="firstName"
                                        name="firstName"
                                        type="text"
                                        placeholder="John"
                                        className="w-full border border-gray-200 rounded-xl px-4 py-2.5 text-sm text-gray-800 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition"
                                    />
                                    <ErrorMessage name="firstName" component="p" className="text-xs text-red-500 mt-0.5" />
                                </div>
                                <div className="flex flex-col gap-1 flex-1">
                                    <label htmlFor="lastName" className="text-sm font-medium text-gray-700">
                                        Last Name
                                    </label>
                                    <Field
                                        id="lastName"
                                        name="lastName"
                                        type="text"
                                        placeholder="Doe"
                                        className="w-full border border-gray-200 rounded-xl px-4 py-2.5 text-sm text-gray-800 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition"
                                    />
                                    <ErrorMessage name="lastName" component="p" className="text-xs text-red-500 mt-0.5" />
                                </div>
                            </div>
                            <div className="flex flex-col gap-1">
                                <label htmlFor="phone" className="text-sm font-medium text-gray-700">
                                    Phone Number
                                </label>
                                <Field
                                    id="phone"
                                    name="phone"
                                    type="tel"
                                    placeholder="+1 234 567 8900"
                                    className="w-full border border-gray-200 rounded-xl px-4 py-2.5 text-sm text-gray-800 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition"
                                />
                                <ErrorMessage name="phone" component="p" className="text-xs text-red-500 mt-0.5" />
                            </div>
                            <div className="flex flex-col gap-1">
                                <label htmlFor="email" className="text-sm font-medium text-gray-700">
                                    Email Address
                                </label>
                                <Field
                                    id="email"
                                    name="email"
                                    type="email"
                                    placeholder="john@example.com"
                                    className="w-full border border-gray-200 rounded-xl px-4 py-2.5 text-sm text-gray-800 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition"
                                />
                                <ErrorMessage name="email" component="p" className="text-xs text-red-500 mt-0.5" />
                            </div>
                            <div className="flex flex-col gap-1">
                                <label htmlFor="message" className="text-sm font-medium text-gray-700">
                                    Message
                                </label>
                                <Field
                                    as="textarea"
                                    id="message"
                                    name="message"
                                    rows={4}
                                    placeholder="Write your message here..."
                                    className="w-full border border-gray-200 rounded-xl px-4 py-2.5 text-sm text-gray-800 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition resize-none"
                                />
                                <ErrorMessage name="message" component="p" className="text-xs text-red-500 mt-0.5" />
                            </div>

                            <button
                                type="submit"
                                className="w-full bg-blue-500 hover:bg-blue-600 text-white text-sm font-semibold py-2.5 rounded-xl transition-colors mt-1"
                            >
                                Send Message
                            </button>
                        </Form>
                    </Formik>
                </div>
            </div>
        </>
    );
}