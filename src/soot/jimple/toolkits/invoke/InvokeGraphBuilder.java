/* Soot - a J*va Optimization Framework
 * Copyright (C) 1997-1999 Patrick Lam
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the Sable Research Group and others 1997-1999.  
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */


package soot.jimple.toolkits.invoke;

import soot.*;
import soot.util.*;
import java.util.*;

/** A transformer which calls upon CHA to build the default invoke graph for the Scene. */
public class InvokeGraphBuilder extends SceneTransformer
{
    public InvokeGraphBuilder( Singletons.Global g ) {}
    public static InvokeGraphBuilder v() { return G.v().InvokeGraphBuilder(); }

  protected void internalTransform(String phaseName, Map options) {
    if (!Scene.v().hasActiveInvokeGraph()) {
      if (Main.opts.verbose())
	G.v().out.println("[] Start building the invoke graph...");

      InvokeGraph invokeGraph = ClassHierarchyAnalysis.newInvokeGraph();
      Scene.v().setActiveInvokeGraph(invokeGraph);
	
      if (Main.opts.verbose())
	G.v().out.println("[] Finished building the invoke graph");
    }
  }
}



