`timescale 1ns / 1ps
module tb ();

   logic    [3:0] a;
   logic    [3:0] b;
   logic 	carryIn;
   logic    [3:0] sum;
   logic    carryOut;
   logic    clk; 
   logic    [3:0] sum_correct;  
   
   integer handle3;
   integer desc3;
   integer i;
   assign sum_correct = a + b + carryIn;

   initial 
    begin
        handle3 = $fopen("testripadder.out");
        desc3 = handle3;
        #3020 $finish;
    end
  // instantiate device under test
   rippleadder dut(a, b, carryIn, 
                    sum, carryOut);

   // 2 ns clock
   initial 
     begin	
	clk = 1'b1;
	forever #10 clk = ~clk;
     end


   initial
     begin
        for (i = 0; i <= 151; i = i+1)
            begin
                @(posedge clk)
                    begin
                        a = $random;
                        b = $random;
                        carryIn = 1'b0;
                    end
                @(negedge clk)
                    begin 
                        $fdisplay(desc3, "%h %h || %h | %h | %b", a, b, sum, sum_correct, (sum == sum_correct));
                    end
            end
     end


   
endmodule