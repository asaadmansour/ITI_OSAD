import { useLottie } from 'lottie-react';
import codingAnimation from '../../animations/coding.json';

export default function AboutMe() {
    const { View } = useLottie({
        animationData: codingAnimation,
        loop: true,
    });

    return (
        <section id="about" className="section-spacing">
            <div className="container-custom">
                <h2 className="text-3xl md:text-4xl font-bold text-blue-600 mb-12">
                    About Me
                </h2>
                
                <div className="grid grid-cols-1 md:grid-cols-2 gap-8 md:gap-12 items-center">
                    <div className="text-gray-700 leading-relaxed space-y-4">
                        <p>
                            Backend software engineer specializing in Java and Node.js, with hands-on 
                            experience building REST APIs and GraphQL services, designing relational 
                            and document-store databases, and shipping production-ready systems.
                        </p>
                        <p>
                            AWS Certified Cloud Practitioner focused on scalable backend architecture, 
                            clean system design, and writing well-tested, maintainable code.
                        </p>
                    </div>
                    
                    <div className="flex items-center justify-center" style={{ width: '100%', maxWidth: '500px' }}>
                        {View}
                    </div>

                </div>
            </div>
        </section>
    )
}