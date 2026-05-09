def create_students(data):
    try:
        students = open("students.txt", "x")
        students.writelines(data)
        students.close()
    except FileExistsError:
        print("File already exists")


def get_students():
    students = open("students.txt", 'r')
    for student in students:
        student_data = student.strip().split(',')
        student_id = student_data[0]
        student_name = student_data[1]
        print(f"{student_name}")
    students.close()

def get_student_grades(student_id):
    result = ""
    students = open('students.txt', 'r')
    sid_found = False
    for student in students:
        student_data = student.strip().split(',')
        sid = student_data[0]
        if sid == '':
            break
        if sid == str(student_id):
            name = student_data[1]
            result += name + " "
            sid_found = True
            break
    students.close()

    if sid_found:
        grades = open('grades.txt', 'r')
        for grade in grades:
            grade_data = grade.strip().split(',')
            sid = grade_data[0]
            subject = grade_data[1]
            score = grade_data[2]
            if sid == str(student_id):
                result += f"{subject} {score} "
        grades.close()

    print(result.strip())


def get_avg():
    students_dict = {}
    students = open("students.txt", 'r')
    for student in students:
        student_data = student.strip().split(',')
        sid = student_data[0]
        name = student_data[1]
        students_dict[sid] = name
    students.close()

    grades_dict = {}
    grades = open("grades.txt", 'r')
    for grade in grades:
        grade_data = grade.strip().split(',')
        sid = grade_data[0]
        subject = grade_data[1]
        score = float(grade_data[2])
        if sid in grades_dict:
            grades_dict[sid].append(score)
        else:
            grades_dict[sid] = [score]
    grades.close()

    for sid in students_dict:
        name = students_dict[sid]
        if sid in grades_dict:
            avg = sum(grades_dict[sid]) / len(grades_dict[sid])
            print(f"{name} - Average: {avg:.2f}")
        else:
            print(f"{name} - No grades")
# get_student_grades(1)
get_avg()