module fulladder(input logic a, b, cin,
                 output logic sum, cout);

        logic g1,g2;

        assign g1 = a ^ b;
        assign g2 = a & b;

        assign sum = g1 ^ cin;
        assign cout = g2 | (g1 & cin);
endmodule

module top_demo
(
        input logic [3:0] sw,
        input logic [3:0] btn,
        output logic [7:0] led
);

        //assign led[3:0] = sw;
        //assign led[7:4] = btn;
        fulladder(sw[0], sw[1], sw[2], led[0], led[1]);

endmodule