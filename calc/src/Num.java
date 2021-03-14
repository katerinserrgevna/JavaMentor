public class Num {
    Integer left;
    Integer right;
    Character sign;
    Integer result = null;

    public Num(){
        left = null;
        right = null;
        sign = null;
    }

    public Num(Integer left, Integer right, Character sign){
        this.left = left;
        this.right = right;
        this.sign = sign;
    }

    public void operation(){
        switch (sign){
            case '+': result = left + right;
                break;
            case '-': result = left - right;
                break;
            case '*': result = left * right;
                break;
            case '/': result = left / right;
                break;
        }
    }

    public void print_result_arab(){
        System.out.println(result);
    }

    public void print_result_roman(){
        try {
            if (result < 0)
                throw new Exception();
            else {
                Parser pars = new Parser();
                String result_str = "";
                Integer res = result;
                Integer ptr;

                if (result == 0) {
                    System.out.println("Результат нулевой. В данной системе нет такого обозначения.");
                    return;
                }

                if (result <= 10) {
                    System.out.println(pars.Roman_num[result - 1]);
                } else {
                    if ((ptr = res % 10) != 0) {
                        for (int i = pars.Roman_num[ptr - 1].length(); i != 0; i--)
                            result_str += pars.Roman_num[ptr - 1].charAt(i - 1);
                    }
                        res /= 10;
                        switch (res) {
                            case 1:
                                result_str += "X";
                                break;
                            case 2:
                                result_str += "XX";
                                break;
                            case 3:
                                result_str += "XXX";
                                break;
                            case 4:
                                result_str += "LX";
                                break;
                            case 5:
                                result_str += "L";
                                break;
                            case 6:
                                result_str += "XL";
                                break;
                            case 7:
                                result_str += "XXL";
                                break;
                            case 8:
                                result_str += "XXXL";
                                break;
                            case 9:
                                result_str += "CX";
                                break;
                            case 10:
                                result_str += "C";
                                break;
                    }
                    for (int i = result_str.length() - 1; i >= 0; i--)
                        System.out.print(result_str.charAt(i));
                }
            }
        }catch (Exception e){
            System.out.println("Отрицательный результат. В данной системе отсутствует обозначение.");
        }
    }
}
