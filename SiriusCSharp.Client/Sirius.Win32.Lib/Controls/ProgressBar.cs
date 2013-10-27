﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Sirius.Win32.Lib.Controls.Interfaces;
using System.Windows.Automation;

namespace Sirius.Win32.Lib.Controls
{
    public class ProgressBar : Control, IRange
    {
        public ProgressBar() 
        {
            this.controlType = ControlType.ProgressBar;
        }

        public double GetLowerBound(int hwnd)
        {
            AutomationElement element = Find(hwnd);
            RangeValuePattern range = element.GetCurrentPattern(RangeValuePattern.Pattern) as RangeValuePattern;
            return range.Current.Minimum;
        }

        public double GetUpperBound(int hwnd)
        {
            AutomationElement element = Find(hwnd);
            RangeValuePattern range = element.GetCurrentPattern(RangeValuePattern.Pattern) as RangeValuePattern;
            return range.Current.Maximum;
        }

        public double GetPosition(int hwnd)
        {
            AutomationElement element = Find(hwnd);
            RangeValuePattern range = element.GetCurrentPattern(RangeValuePattern.Pattern) as RangeValuePattern;
            return range.Current.Value;
        }

        public void SetPosition(int hwnd, double pos)
        {
            AutomationElement element = Find(hwnd);
            RangeValuePattern range = element.GetCurrentPattern(RangeValuePattern.Pattern) as RangeValuePattern;
            range.SetValue( pos );
        }

        public double GetSmallStep(int hwnd) 
        { 
            AutomationElement element = Find(hwnd);
            RangeValuePattern range = element.GetCurrentPattern(RangeValuePattern.Pattern) as RangeValuePattern;
            return range.Current.SmallChange;
        }

        public double GetLargeStep(int hwnd)
        {
            AutomationElement element = Find(hwnd);
            RangeValuePattern range = element.GetCurrentPattern(RangeValuePattern.Pattern) as RangeValuePattern;
            return range.Current.LargeChange;
        }
    }
}