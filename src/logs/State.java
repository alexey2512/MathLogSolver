package logs;

import bricks.Expression;

import java.util.List;

public enum State {

    SCHEME {
        private final List<String> baseNames = List.of("A", "B", "C");
        public Expression[] args;
        public int count;
        public int schemeIndex;

        @Override
        public void setData(int schemeIndex, Expression[] args) {
            this.schemeIndex = schemeIndex;
            count = switch (schemeIndex) {
                case 9 -> 1;
                case 0, 2, 3, 4, 5, 6 -> 2;
                case 1, 7, 8 -> 3;
                default -> 0;
            };
            this.args = args;
        }

        @Override
        public String getLog() {
            StringBuilder sb = new StringBuilder();
            sb.append("(sch. ").append(schemeIndex + 1);
            for (int i = 0; i < count; i++) {
                sb.append(", ").append(baseNames.get(i)).append(" := ").append(args[i].toString());
            }
            sb.append(')');
            return sb.toString();
        }
    },

    HYPOTHESIS {
        @Override
        public String getLog() {
            return "(hypothesis)";
        }
    },

    MODUS_PONENS {
        public int com, imp;

        @Override
        public void setData(int com, int imp) {
            this.com = com;
            this.imp = imp;
        }

        @Override
        public String getLog() {
            return "(M.P. " + (com + 1) + ", " + (imp + 1) + ")";
        }

        @Override
        public int getCom() {
            return com;
        }

        @Override
        public int getImp() {
            return imp;
        }

    };

    public void setData(int schemeIndex, Expression[] args) {
        throw new UnsupportedOperationException("Operation not supported for this state");
    }

    public void setData(int com, int imp) {
        throw new UnsupportedOperationException("Operation not supported for this state");
    }

    public int getCom() {
        throw new UnsupportedOperationException("Operation not supported for this state");
    }

    public int getImp() {
        throw new UnsupportedOperationException("Operation not supported for this state");
    }

    public abstract String getLog();
}
