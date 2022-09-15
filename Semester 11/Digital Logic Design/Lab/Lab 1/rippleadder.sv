module rippleadder(input logic a, b, cin,
                   output logic sum, cout);

        logic g1,g2;

        assign g1 = a ^ b;
        assign g2 = a & b;

        assign sum = g1 ^ cin;
        assign cout = g2 | (g1 & cin);
   
endmodule

module 
