/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres.Almiray
 */
class ChartsGriffonPlugin {
    // the plugin version
    String version = '0.4'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '0.9.5']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, qt
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-colorchooser-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'JFreeCharts support'
    // accepts Markdown syntax. See http://daringfireball.net/projects/markdown/ for details
    String description = '''
Provides integration with [JFreeChart][1] by means of [ChartBuilder][2].

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| Node  | Property          | Type                | Default                                | Required | Bindable |
| ----- | ----------------- | ------------------- | -------------------------------------- | -------- | -------- |
| chart | chart             | JFreeChart or Class |                                        | yes      | no       |
|       | width             | int                 | ChartPanel.DEFAULT_WIDTH               | no       | no       |
|       | height            | int                 | ChartPanel.DEFAULT_HEIGHT              | no       | no       |
|       | minimumDrawWidth  | int                 | ChartPanel.DEFAULT_MINIMUM_DRAW_WIDTH  | no       | no       |
|       | minimumDrawHeight | int                 | ChartPanel.DEFAULT_MINIMUM_DRAW_HEIGHT | no       | no       |
|       | maximumDrawWidth  | int                 | ChartPanel.DEFAULT_MAXIMUM_DRAW_WIDTH  | no       | no       |
|       | maximumDrawHeight | int                 | ChartPanel.DEFAULT_MAXIMUM_DRAW_HEIGHT | no       | no       |
|       | useBuffer         | boolean             | true                                   | no       | no       |
|       | properties        | boolean             | true                                   | no       | no       |
|       | copy              | boolean             | true                                   | no       | no       |
|       | save              | boolean             | true                                   | no       | no       |
|       | print             | boolean             | true                                   | no       | no       |
|       | zoom              | boolean             | true                                   | no       | no       |
|       | tooltips          | boolean             | true                                   | no       | no       |

If a Class is set as the value for `chart:` then it's assumed to be a script that can be parsed using ChartBuilder 

## Scripts ##

 *  **create-chart** - creates a new Chart script that can be parsed using ChartBuilder

### Example

Chart scripts have access to all variables form their surrounding contextt. This means that a chart can read properties
from a Model if the chart is built inside a View script. Here's how the typical chart Script looks like

__griffon-app/conf/charts/sample/SampleChart.groovy__
        
        package sample
		import java.awt.Color
		import java.awt.Font
		import org.jfree.chart.labels.PieToolTipGenerator
 
		def largeFont = new Font("Arial", Font.BOLD, 15);
 
		piechart3d(title: "Simple Pie Chart") {
		    defaultPieDataset {
		        Series1(40.0f)
		        Series2(30.0f)
		        Series3(30.0f)
		    }
		    antiAlias = true
		    backgroundPaint(Color.WHITE)
 
		    pieplot {
		        sectionOutlinesVisible false
		        labelFont largeFont
		        labelGap 0.02
		        toolTipGenerator ({ dataset, key -> return "[${dataset} ${key}]" as String } as PieToolTipGenerator)
 
		        sectionPaint('Series1', paint: new Color(255,0,0))
		        sectionPaint('Series2', paint: new Color(0,255,0))
		        sectionPaint('Series3', paint: new Color(0,0,255))
		    }
		}

This is how the previously defined chart may be embedded in a View

__griffon-app/views/sample/SampleView.groovy

        package sample
		application(title: 'Charts',
		  preferredSize: [320, 240],
		  pack: true,
		  locationByPlatform:true,
		  iconImage: imageIcon('/griffon-icon-48x48.png').image,
		  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
		               imageIcon('/griffon-icon-32x32.png').image,
		               imageIcon('/griffon-icon-16x16.png').image]) {
		    chart(SampleChart)
		}

[1]: http://www.jfree.org/jfreechart
[2]: https://java.net/projects/groovychart
'''
}
