package prog.kiev;

public class main {
    public static void main(String[] args) {
        Human person = new Human("Tom", "White", Sex.MALE);
        //System.out.println(person);

        Student[] studList = new Student[8];
        for(int i=0;i<studList.length;i++){
            studList[i] = new Student("name"+i,"surname"+i,Sex.MALE, 123+i);
        }

		for(Student student: studList){
			System.out.println(student);
		}


        Group DO = new Group("DO-3");
        try {
            for (int i = 0; i < studList.length; i++) {
                DO.Add(studList[i]);
            }
        }catch (OutOfGroupException e){
            System.out.println(e.getMessage());
        }

        try {
        System.out.println(DO);
        System.out.println();
        DO.delete(124);
        System.out.println(DO);

        System.out.println(DO.find("surname5"));
    }catch (OutOfGroupException e)
    {
        System.out.println(e.getMessage());
    }

    }
}

