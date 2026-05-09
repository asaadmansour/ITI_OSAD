def create(data):
    try:
        grades = open('grades.txt','x')
        grades.writelines(data)
        grades.close()
    except:
        print("file already exists")


def get(subject):
    grades = open('grades.txt','r')

    for grade in grades:
        grade_data = grade.strip().split(',')
        student_id = grade_data[0]
        subject_name = grade_data[1]
        subject_grade = grade_data[2]

        if subject_name == subject:
            print(f"{student_id} - {subject_name} - {subject_grade}")

    grades.close()