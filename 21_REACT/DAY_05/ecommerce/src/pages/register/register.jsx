import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import NavBar from "../../components/nav-bar/NavBar";
import { useNavigate } from "react-router-dom";
const initialValues = {
    name: "",
    email: "",
    username: "",
    password: "",
    confirmPassword: ""
};

const registerSchema = Yup.object({
    name: Yup.string().required("Name is required"),
    email: Yup.string().email("Invalid Email").required("Email is required"),
    username: Yup.string().min(3, "Min 3 chars for username").required("Username is required"),
    password: Yup.string().min(6, "Password too short").required("Password is required"),
    confirmPassword: Yup.string()
        .oneOf([Yup.ref("password")], "Passwords must match")
        .required("Confirm your password"),
});

export default function Register() {
const navigate = useNavigate();
    return (
        <>
            <NavBar />
            <div className="min-h-screen bg-gray-50 pt-16 flex items-center justify-center px-4 py-10">
                <div className="w-full max-w-md bg-white rounded-2xl shadow-sm p-8">
                    <div className="mb-8">
                        <h1 className="text-2xl font-bold text-gray-800">Create an account</h1>
                        <p className="text-sm text-gray-500 mt-1">Fill in the details below to get started</p>
                    </div>
                        <Formik
                        initialValues={initialValues}
                        validationSchema={registerSchema}
                        onSubmit={(values) => {
                            localStorage.setItem("username", values.username);
                            navigate('/');
                        }}
                        >
                        <Form className="flex flex-col gap-5">
                            <div className="flex flex-col gap-1">
                                <label htmlFor="name" className="text-sm font-medium text-gray-700">
                                    Full Name
                                </label>
                                <Field
                                    id="name"
                                    name="name"
                                    type="text"
                                    placeholder="John Doe"
                                    className="w-full border border-gray-200 rounded-xl px-4 py-2.5 text-sm text-gray-800 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition"
                                />
                                <ErrorMessage name="name" component="p" className="text-xs text-red-500 mt-0.5" />
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
                                <label htmlFor="username" className="text-sm font-medium text-gray-700">
                                    Username
                                </label>
                                <Field
                                    id="username"
                                    name="username"
                                    type="text"
                                    placeholder="johndoe"
                                    className="w-full border border-gray-200 rounded-xl px-4 py-2.5 text-sm text-gray-800 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition"
                                />
                                <ErrorMessage name="username" component="p" className="text-xs text-red-500 mt-0.5" />
                            </div>
                            <div className="flex flex-col gap-1">
                                <label htmlFor="password" className="text-sm font-medium text-gray-700">
                                    Password
                                </label>
                                <Field
                                    id="password"
                                    name="password"
                                    type="password"
                                    placeholder="Min. 6 characters"
                                    className="w-full border border-gray-200 rounded-xl px-4 py-2.5 text-sm text-gray-800 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition"
                                />
                                <ErrorMessage name="password" component="p" className="text-xs text-red-500 mt-0.5" />
                            </div>
                            <div className="flex flex-col gap-1">
                                <label htmlFor="confirmPassword" className="text-sm font-medium text-gray-700">
                                    Confirm Password
                                </label>
                                <Field
                                    id="confirmPassword"
                                    name="confirmPassword"
                                    type="password"
                                    placeholder="Repeat your password"
                                    className="w-full border border-gray-200 rounded-xl px-4 py-2.5 text-sm text-gray-800 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent transition"
                                />
                                <ErrorMessage name="confirmPassword" component="p" className="text-xs text-red-500 mt-0.5" />
                            </div>
                            <button
                                type="submit"
                                className="w-full bg-blue-500 hover:bg-blue-600 text-white text-sm font-semibold py-2.5 rounded-xl transition-colors mt-1"
                            >
                                Create Account
                            </button>
                        </Form>
                    </Formik>
                </div>
            </div>
        </>
    );
}