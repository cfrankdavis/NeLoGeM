/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamics;

import java.awt.*;

/**
 *
 * @author CFD
 */
public class VecFont {
	/* graphics character set ( 5 wide x 10 high )
  	 Each row begins with a vector count N , followed by N 2-byte vectors.
	   Each vector is stored with X in high nibble (msb not used), Y in low nibble,
	   0x04 is location of bottom left of character on line.
 	  0x4A is top rightmost
	*/
	private final static int MAXASCENT = 6;
	private final static int MAXDESCENT = 3;
	private final static int LEADING = 1;		// space between rows
	private final static int MAXADVANCE = 6;	// width of chars including gap
	private final static int CHARWIDTH = 5;		// (fixed) char width
	private final static int MAXCHAR = 127;

	private final static byte gchars[][] = {
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{4,0x12,0x04,0x16,0x04,0x04,0x44,0x44,0x49},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{1,0x32,0x32},
	{0},							// space
	{2,0x24,0x24,0x26,0x2a},				// !
	{2,0x1a,0x18,0x3a,0x38},				// "
	{4,0x14,0x18,0x34,0x38,0x07,0x47,0x05,0x45},		// #
	{6,0x05,0x45,0x45,0x47,0x47,0x07,0x07,0x09,0x09,0x49,0x2a,0x24},	// $
	{11,0x04,0x05,0x05,0x49,0x49,0x4a,0x0a,0x08,0x08,0x28,0x28,0x2a,0x2a,0x0a,0x24,0x44,0x44,0x46,0x46,0x26,0x26,0x24},	// %
	{8,0x44,0x08,0x08,0x0a,0x0a,0x3a,0x3a,0x39,0x39,0x06,0x06,0x04,0x04,0x24,0x24,0x46},	// &
	{2,0x18,0x29,0x29,0x3a},				// '
	{3,0x34,0x16,0x16,0x18,0x18,0x3a},			// (
	{3,0x14,0x36,0x36,0x38,0x38,0x1a},			// )
	{4,0x06,0x46,0x24,0x28,0x04,0x48,0x08,0x44},		// *
	{2,0x24,0x28,0x06,0x46},				// +
	{2,0x25,0x24,0x13,0x24},				// '
	{2,0x16,0x26,0x26,0x36},				// -
	{2,0x24,0x24,0x24,0x24},				// .
	{3,0x04,0x05,0x05,0x49,0x49,0x4a},			// /
	{4,0x04,0x0a,0x0a,0x4a,0x4a,0x44,0x44,0x04},		// 0
	{2,0x24,0x2a,0x2a,0x19},				// 1
	{5,0x44,0x04,0x04,0x07,0x07,0x47,0x47,0x4a,0x4a,0x0a},	// 2
	{4,0x04,0x44,0x44,0x4a,0x4a,0x0a,0x47,0x07},		// 3
	{3,0x0a,0x07,0x07,0x47,0x34,0x3a},			// 4
	{5,0x04,0x44,0x44,0x47,0x47,0x07,0x07,0x0a,0x0a,0x4a},	// 5
	{5,0x4a,0x0a,0x0a,0x04,0x04,0x44,0x44,0x47,0x47,0x07},	// 6
	{4,0x0a,0x4a,0x4a,0x49,0x49,0x16,0x16,0x14},		// 7
	{9,0x04,0x07,0x07,0x47,0x47,0x44,0x44,0x04,0x27,0x09,0x09,0x0a,0x0a,0x4a,0x4a,0x49,0x49,0x27},	// 8
	{5,0x04,0x44,0x44,0x4a,0x4a,0x0a,0x0a,0x07,0x07,0x47},	// 9
	{2,0x24,0x24,0x27,0x27},				// :
	{3,0x13,0x24,0x24,0x25,0x27,0x27},			// ;
	{2,0x34,0x16,0x16,0x38},				// <
	{2,0x05,0x45,0x07,0x47},				// =
	{2,0x14,0x36,0x36,0x18},				// >
	{6,0x24,0x24,0x25,0x47,0x47,0x49,0x49,0x3a,0x3a,0x1a,0x1a,0x09},	// ?
	{7,0x24,0x04,0x04,0x0a,0x0a,0x4a,0x4a,0x46,0x46,0x26,0x26,0x28,0x28,0x48},	// @
	{4,0x04,0x0a,0x0a,0x4a,0x4a,0x44,0x47,0x07},		// A
	{8,0x04,0x0a,0x0a,0x3a,0x3a,0x38,0x38,0x27,0x07,0x37,0x37,0x46,0x46,0x44,0x44,0x04},	// B
	{5,0x4a,0x2a,0x2a,0x08,0x08,0x06,0x06,0x24,0x24,0x44},	// C
	{6,0x04,0x0a,0x0a,0x2a,0x2a,0x48,0x48,0x46,0x46,0x24,0x24,0x04},	// D
	{4,0x4a,0x0a,0x0a,0x04,0x04,0x44,0x07,0x27},		// E
	{3,0x04,0x0a,0x0a,0x4a,0x07,0x27},			// F
	{5,0x4a,0x0a,0x0a,0x04,0x04,0x44,0x44,0x46,0x46,0x26},	// G
	{3,0x04,0x0a,0x07,0x47,0x4a,0x44},			// H
	{3,0x14,0x34,0x24,0x2a,0x1a,0x3a},			// I
	{3,0x06,0x04,0x04,0x44,0x44,0x4a},			// J
	{4,0x0a,0x04,0x07,0x17,0x17,0x4a,0x17,0x44},		// K
	{2,0x0a,0x04,0x04,0x44},				// L
	{5,0x04,0x0a,0x0a,0x28,0x28,0x4a,0x4a,0x44,0x28,0x27},	// M
	{3,0x04,0x0a,0x09,0x45,0x4a,0x44},			// N
	{8,0x14,0x05,0x05,0x09,0x09,0x1a,0x1a,0x3a,0x3a,0x49,0x49,0x45,0x45,0x34,0x34,0x14},	// O
	{4,0x07,0x47,0x47,0x4a,0x4a,0x0a,0x0a,0x04},		// P
	{5,0x04,0x0a,0x0a,0x4a,0x4a,0x44,0x44,0x04,0x26,0x44},	// Q
	{5,0x04,0x0a,0x0a,0x4a,0x4a,0x47,0x47,0x07,0x17,0x44},	// R
	{5,0x04,0x44,0x44,0x47,0x47,0x07,0x07,0x0a,0x0a,0x4a},	// S
	{2,0x24,0x2a,0x0a,0x4a},				// T
	{3,0x0a,0x04,0x04,0x44,0x44,0x4a},			// U
	{4,0x0a,0x06,0x06,0x24,0x24,0x46,0x46,0x4a},		// V
	{5,0x0a,0x04,0x04,0x26,0x26,0x44,0x44,0x4a,0x26,0x27},	// W
	{6,0x04,0x05,0x05,0x49,0x49,0x4a,0x0a,0x09,0x09,0x45,0x45,0x44},	// X
	{5,0x0a,0x09,0x09,0x27,0x27,0x49,0x49,0x4a,0x27,0x24},	// Y
	{5,0x0a,0x4a,0x4a,0x49,0x49,0x05,0x05,0x04,0x04,0x44},	// Z
	{3,0x34,0x14,0x14,0x1a,0x1a,0x3a},			// [
	{3,0x0a,0x09,0x09,0x45,0x45,0x44},			// \
	{3,0x14,0x34,0x34,0x3a,0x3a,0x1a},			// ]
	{2,0x08,0x2a,0x2a,0x48},				// ^
	{1,0x02,0x62},						// _
	{1,0x37,0x29},						// `
	{5,0x46,0x24,0x24,0x04,0x04,0x08,0x08,0x48,0x48,0x44},	// a
	{4,0x0a,0x04,0x04,0x44,0x44,0x48,0x48,0x08},		// b
	{3,0x48,0x08,0x08,0x04,0x04,0x44},			// c
	{4,0x48,0x08,0x08,0x04,0x04,0x44,0x44,0x4a},		// d
	{5,0x06,0x46,0x46,0x48,0x48,0x08,0x08,0x04,0x04,0x44},	// e
	{4,0x04,0x08,0x08,0x2a,0x2a,0x4a,0x07,0x37},		// f
	{5,0x44,0x04,0x04,0x08,0x08,0x48,0x48,0x42,0x42,0x02},	// g
	{3,0x04,0x0a,0x08,0x48,0x48,0x44},			// h
	{2,0x24,0x28,0x2a,0x2a},				// i
	{3,0x28,0x22,0x22,0x02,0x2a,0x2a},			// j
	{4,0x04,0x0a,0x06,0x26,0x26,0x48,0x26,0x44},		// k
	{2,0x2a,0x25,0x25,0x34},				// l
	{4,0x04,0x08,0x08,0x48,0x48,0x44,0x28,0x24},		// m
	{3,0x04,0x08,0x08,0x48,0x48,0x44},			// n
	{4,0x04,0x08,0x08,0x48,0x48,0x44,0x44,0x04},		// o
	{4,0x04,0x44,0x44,0x48,0x48,0x08,0x08,0x02},		// p
	{4,0x44,0x04,0x04,0x08,0x08,0x48,0x48,0x42},		// q
	{3,0x14,0x18,0x16,0x38,0x38,0x48},			// r
	{5,0x48,0x08,0x08,0x06,0x06,0x46,0x46,0x44,0x44,0x04},	// s
	{5,0x19,0x15,0x15,0x24,0x24,0x34,0x34,0x45,0x08,0x38},	// t
	{3,0x08,0x04,0x04,0x44,0x44,0x48},			// u
	{4,0x08,0x06,0x06,0x24,0x24,0x46,0x46,0x48},		// v
	{4,0x08,0x04,0x04,0x26,0x26,0x44,0x44,0x48},		// w
	{2,0x08,0x44,0x04,0x48},				// x
	{4,0x08,0x04,0x04,0x44,0x48,0x42,0x42,0x02},		// y
	{3,0x08,0x48,0x48,0x04,0x04,0x44},			// z
	{6,0x44,0x34,0x34,0x16,0x16,0x18,0x18,0x3a,0x3a,0x4a,0x07,0x17},	// {
	{2,0x2a,0x28,0x26,0x24},				// |
	{6,0x04,0x14,0x14,0x36,0x36,0x38,0x38,0x1a,0x1a,0x0a,0x37,0x47},	// }
	{3,0x09,0x1a,0x1a,0x38,0x38,0x49},			// ~
	{3,0x05,0x45,0x07,0x47,0x09,0x49}			// del
	};

	// these get methods mirror those of java.awt.FontMetrics
	public static int getMaxAscent() {
		return MAXASCENT;
	}

	public static int getMaxDescent() {
		return MAXDESCENT;
	}

	public static int getMaxAdvance() {
		return MAXADVANCE;
	}

	public static int getLeading() {
		return LEADING;
	}

	public static int getHeight() {
		return MAXASCENT + MAXDESCENT + LEADING;
	}

	public static int stringWidth(String str) {
		int len = str.length();
		if(len < 1) return 0;
		else return CHARWIDTH + ((len - 1) * MAXADVANCE);	// gatepost effect
	}

	public static int getMaxAscent(double scale) {
		// used for horizontal text only
		return (int)(scale * MAXASCENT);
	}

	public static int getMaxDescent(double scale) {
		return (int)(scale * MAXDESCENT);
	}

	public static int getMaxAdvance(double scale) {
		return (int)(scale * MAXADVANCE);
	}

	public static int getLeading(double scale) {
		return (int)(scale * LEADING);
	}

	public static int getHeight(double scale) {
		return getMaxAscent(scale) + getMaxDescent(scale) + getLeading(scale);
	}

	public static int stringWidth(String str, double scale) {
		int len = str.length();
		if (len < 1) return 0;
		else return (int)((scale * CHARWIDTH) + (scale * (len - 1) * MAXADVANCE));
	}

	// 3 methods for drawing strings - fixed size, variable size, or variable size and rotation
        // 2015 version using eye and clipping
	public static void drawString( Eye eye, Graphics g, String str, int stroffset, StateVector s, double zdepth ) {
            if ( s.z < 0 ) {
                int c, i, j, p, x1, y1, x2, y2, nv2, xoff, yoff;
                byte	charvecs[];
                StateVector v = new StateVector();
                int numch = str.length();
                int x = (int)s.x;
                int y = (int)s.y;
                xoff = x + stroffset;
                yoff = y - 1 - MAXDESCENT + stroffset;

                for(i=0; i<numch; i++, xoff += MAXADVANCE) {
                    c = str.charAt(i);
                    if((c < 0) || (c > MAXCHAR)) c = 0;
                    charvecs = gchars[c];
                    nv2 = 2 * charvecs[0];
                    for(j = 1; j < nv2; j += 2) {
                        // vecFont code does y inversion for screen.
                        // this has to be undone for eye screen with central origin rather than top left origin.
                        p = charvecs[j];
                        v.x = xoff + (p >>> 4);
                        v.y = ( yoff + (p & 15) );
                        v.z = s.z;
                        p = charvecs[j+1];
                        v.vx = xoff + (p >>> 4);
                        v.vy = ( yoff + (p & 15) );
                        v.vz = s.z;

                        v.z = zdepth;
                        eye.paintVector( g, v, false, 5, 0, 1, 0, 0);
                    }
                }
//              if ( str.equals( "275") ) System.out.println( "draw "+ zdepth );
            }
	}

	public static void drawString(Graphics g, String str, int x, int y) {
		int c, i, j, p, x1, y1, x2, y2, nv2, xoff, yoff;
		byte	charvecs[];
		int numch = str.length();
		xoff = x;
		yoff = y + 1 + MAXDESCENT;
		for(i=0; i<numch; i++, xoff += MAXADVANCE) {
			c = str.charAt(i);
			if((c < 0) || (c > MAXCHAR)) c = 0;
			charvecs = gchars[c];
			nv2 = 2 * charvecs[0];
			for(j = 1; j < nv2; j += 2) {
				p = charvecs[j];
				x1 = xoff + (p >>> 4);
				y1 = yoff - (p & 15);
				p = charvecs[j+1];
				x2 = xoff + (p >>> 4);
				y2 = yoff - (p & 15);
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}


        public static void drawString(Graphics g, String str, int x, int y, double scale) {
		int c, i, j, p, x1, y1, x2, y2, nv2, xoff, yoff, xinc;
		byte	charvecs[];
		int numch = str.length();
		xoff = x;
		// yoff = (int)(scale * (1 + MAXDESCENT) + y + 0.5);
		// xinc = (int)(scale * MAXADVANCE + 0.5);
		yoff = y + (int)(scale * (1 + MAXDESCENT));
		xinc = (int)(scale * MAXADVANCE);

		for(i=0; i<numch; i++, xoff += xinc) {
			c = str.charAt(i);
			if((c < 0) || (c > MAXCHAR)) c = 0;
			charvecs = gchars[c];
			nv2 = 2 * charvecs[0];
			for(j = 1; j < nv2; j += 2) {
				p = charvecs[j];
				x1 = xoff + (int)(scale * (p >>> 4));
				y1 = yoff - (int)(scale * (p & 15));
				p = charvecs[j+1];
				x2 = xoff + (int)(scale * (p >>> 4));
				y2 = yoff - (int)(scale * (p & 15));
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}

	public static void drawString(Graphics g, String str, int x, int y,
			double scale, double angle) {
		// angle is in DEGREES.
		// after much experimentation decided that it is worth properly
		// rounding the answers.
		// Notice that this routine can give a slightly longer length of text
		// when scale is non-integer and angle = 0.0 than the version above,
		// which makes each character the same width.
		int c, cx, cy, i, j, p, x1, y1, x2, y2, nv2, xoff, yoff, xinc;
		double scos, ssin;
		byte	charvecs[];
		int numch = str.length();
		xoff = 0;
		yoff = 1 + MAXDESCENT;
		xinc = MAXADVANCE;
		angle = angle * Math.PI / 180.0;
		scos = scale * Math.cos(angle);
		ssin = scale * Math.sin(angle);
		for(i=0; i<numch; i++, xoff += xinc) {
			c = str.charAt(i);
			if((c < 0) || (c > MAXCHAR)) c = 0;
			charvecs = gchars[c];
			nv2 = 2 * charvecs[0];
			for(j = 1; j < nv2; j += 2) {
				p = charvecs[j];
				cx = xoff + (p >>> 4);
				cy = yoff - (p & 15);
				// this is exact but a tad slow:
				x1 = (int)(x + 0.5 + ((cx * scos) + (cy * ssin)));
				y1 = (int)(y + 0.5 + ((cy * scos) - (cx * ssin)));
				// whereas this may be faster but less accurate:
				// x1 = x + (int)((cx * scos) + (cy * ssin));
				// y1 = y + (int)((cy * scos) - (cx * ssin));
				p = charvecs[j+1];
				cx = xoff + (p >>> 4);
				cy = yoff - (p & 15);
				x2 = (int)(x + 0.5 + ((cx * scos) + (cy * ssin)));
				y2 = (int)(y + 0.5 + ((cy * scos) - (cx * ssin)));
				// x2 = x + (int)((cx * scos) + (cy * ssin));
				// y2 = y + (int)((cy * scos) - (cx * ssin));

				g.drawLine(x1, y1, x2, y2);
			}
		}
	}

}
